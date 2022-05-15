package io.rachidassouani.fraud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudCheckHistoryController {

    private static final Logger logger = LoggerFactory.getLogger(FraudCheckHistoryController.class);
    private final FraudCheckHistoryService fraudCheckHistoryService;

    public FraudCheckHistoryController(FraudCheckHistoryService fraudCheckHistoryService) {
        this.fraudCheckHistoryService = fraudCheckHistoryService;
    }

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId) {
        logger.info("fraud check request for customer : " + customerId);
        boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
