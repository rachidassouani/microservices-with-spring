package io.rachidassouani.notification;

import io.rachidassouani.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void send(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setToCustomerId(notificationRequest.getCustomerId());
        notification.setToCustomerEmail(notificationRequest.getCustomerEmail());
        notification.setSender("Me");
        notification.setMessage(notificationRequest.getMessage());
        notification.setSentAt(LocalDateTime.now());

        notificationRepository.save(notification);
    }
}
