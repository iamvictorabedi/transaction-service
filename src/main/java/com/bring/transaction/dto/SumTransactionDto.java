package com.bring.transaction.dto;


import java.util.List;

import com.bring.transaction.helper.MonetaryAmount;
import lombok.Builder;
import lombok.Value;

/**
 * SumTransactionDto
 */
@Value
@Builder
public class SumTransactionDto {
    private MonetaryAmount totalAmount;
    private List<TransactionDto> transactions;
}
