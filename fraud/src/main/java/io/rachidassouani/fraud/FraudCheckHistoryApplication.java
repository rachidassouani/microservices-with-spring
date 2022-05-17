package io.rachidassouani.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FraudCheckHistoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudCheckHistoryApplication.class, args);
    }
}
