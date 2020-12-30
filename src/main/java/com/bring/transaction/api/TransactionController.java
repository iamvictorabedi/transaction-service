package com.bring.transaction.api;

import java.util.List;

import com.bring.transaction.dto.SumTransactionDto;
import com.bring.transaction.dto.TransactionDto;
import com.bring.transaction.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "transactions", produces = APPLICATION_JSON_VALUE)
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    @ApiOperation("Fetch all transactions")
    public List<TransactionDto> getTransactions() {
        log.info("Request to fetch transactions initiated");
        return transactionService.getTransactions();
    }


    @GetMapping("/filter/type")
    @ApiOperation("Fetch transaction by type")
    public List<TransactionDto> fetchTransactionByType(@RequestParam final String type) {
        log.info("Request to fetch transactions of type {} initiated", type);
        return transactionService.fetchByType(type);
    }


    @GetMapping("/totals")
    @ApiOperation("Fetch transaction by type")
    public SumTransactionDto getTransactionTotals() {
        log.info("Request to get sum of all transaction initiated");
        return transactionService.getTotals();
    }

}
