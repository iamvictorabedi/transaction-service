package com.bring.transaction.service;

import java.math.BigDecimal;
import java.util.List;

import com.bring.transaction.client.openapi.OpenApiClient;
import com.bring.transaction.dto.SumTransactionDto;
import com.bring.transaction.dto.TransactionDto;
import com.bring.transaction.helper.MonetaryAmount;
import com.bring.transaction.service.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionMapper mapper;
    private final OpenApiClient openApiClient;

    @Override
    public List<TransactionDto> getTransactions() {
        return this.openApiClient.fetchTransactions().getTransactions()
                .stream()
                .map(this.mapper::toTransactionDto)
                .collect(toList());
    }

    @Override
    public List<TransactionDto> fetchByType(String type) {
        return this.openApiClient.fetchTransactions().getTransactions()
                .stream()
                .filter(openApiTransaction -> openApiTransaction.getDetails().getType().equals(type))
                .map(this.mapper::toTransactionDto)
                .collect(toList());
    }

    @Override
    public SumTransactionDto getTotals() {
        final List<TransactionDto> transactionDto = this.openApiClient.fetchTransactions().getTransactions()
                .stream()
                .map(this.mapper::toTransactionDto)
                .collect(toList());

        final String currency = transactionDto.stream()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getInstructedCurrency();

        final  BigDecimal amount = transactionDto.stream().map(transactionDto1 -> new BigDecimal(transactionDto1.getInstructedAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return SumTransactionDto.builder()
                .totalAmount(new MonetaryAmount(currency,amount))
                .transactions(transactionDto)
                .build();
    }
}
