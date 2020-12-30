package com.bring.transaction.dto;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;

/**
 * Transaction Class
 */
@Getter
@Value
@ToString
public class TransactionDto {
    String id;
    String accountId;
    String counterpartyAccount;
    String counterpartyName;
    String counterPartyLogoPath;
    String instructedAmount;
    String instructedCurrency;
    String transactionAmount;
    String transactionCurrency;
    String transactionType;
    String description;
}
