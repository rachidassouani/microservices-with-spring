package io.rachidassouani.customer;

import io.rachidassouani.clients.fraud.FraudCheckResponse;
import io.rachidassouani.clients.fraud.FraudClient;
import io.rachidassouani.clients.notification.NotificationClient;
import io.rachidassouani.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public CustomerService(CustomerRepository customerRepository, FraudClient fraudClient, RestTemplate restTemplate, NotificationClient notificationClient) {
        this.customerRepository = customerRepository;
        this.fraudClient = fraudClient;
        this.notificationClient = notificationClient;
    }

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = new Customer();
        customer.setEmail(customerRegistrationRequest.getEmail());
        customer.setFirstName(customerRegistrationRequest.getFirstName());
        customer.setLastName(customerRegistrationRequest.getLastName());

        customerRepository.saveAndFlush(customer);

        // check if customer is a fraudster by calling fraud service

        // No need of below code, since I use fraudClient with FeignClient
        /*
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());
         */

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setCustomerId(customer.getId());
        notificationRequest.setCustomerEmail(customer.getEmail());
        notificationRequest.setMessage(String.format("Hello, %s ", customer.getFirstName()));

        notificationClient.sendNotification(notificationRequest);
    }
}
