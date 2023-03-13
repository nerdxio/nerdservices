package io.nerd.fraud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID) {
        var isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerID);
        log.info("fraud check request from customer {}",customerID);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
