package io.rachidassouani.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isFraudulentCustomer(Long customerId) {
        FraudCheckHistory fraudCheckHistory = new FraudCheckHistory();
        fraudCheckHistory.setFraudster(false);
        fraudCheckHistory.setCustomerId(customerId);
        fraudCheckHistory.setCreatedAt(LocalDateTime.now());
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
