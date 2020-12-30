package com.bring.transaction.service;

import java.util.List;

import com.bring.transaction.dto.SumTransactionDto;
import com.bring.transaction.dto.TransactionDto;

public interface TransactionService {
    /**
     * @return Transactions
     */
    List<TransactionDto> getTransactions();

    List<TransactionDto> fetchByType(String type);

    /**
     * @return SumTransactions
     */
    SumTransactionDto getTotals();
}
