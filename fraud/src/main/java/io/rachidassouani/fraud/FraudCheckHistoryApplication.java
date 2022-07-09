package io.rachidassouani.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "io.rachidassouani.clients")
public class FraudCheckHistoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudCheckHistoryApplication.class, args);
    }
}
