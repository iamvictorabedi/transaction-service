package com.bring.transaction.service;

import java.math.BigDecimal;
import java.util.List;

import com.bring.transaction.client.openapi.Account;
import com.bring.transaction.client.openapi.Details;
import com.bring.transaction.client.openapi.OpenApiClient;
import com.bring.transaction.client.openapi.OpenApiTrans;
import com.bring.transaction.client.openapi.OpenApiTransaction;
import com.bring.transaction.client.openapi.Value;
import com.bring.transaction.dto.SumTransactionDto;
import com.bring.transaction.dto.TransactionDto;
import com.bring.transaction.helper.MonetaryAmount;
import com.bring.transaction.service.mapper.TransactionMapper;
import com.bring.transaction.service.mapper.TransactionMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImpTest {
    @Mock
    private OpenApiClient openApiClient;

    private TransactionServiceImpl service;
    private final TransactionMapper mapper = new TransactionMapperImpl();


    @BeforeEach
    void setUp() {
        this.service = new TransactionServiceImpl(mapper, openApiClient);
    }

    @Test
    void canFetchAllTransactions() {
        when(openApiClient.fetchTransactions()).thenReturn(getTransactions());
        final List<TransactionDto> transactions = service.getTransactions();
        verify(openApiClient).fetchTransactions();
        assertThat(transactions).hasSize(1);

    }


    @Test
    void canFetchTransactionsByType() {
        when(openApiClient.fetchTransactions()).thenReturn(getTransactions());
        final List<TransactionDto> transactionDtos = service.fetchByType("SEPA");
        verify(openApiClient).fetchTransactions();
        assertThat(transactionDtos).hasSize(1);
    }


    @Test
    void canGetSumTransaction() {
        when(openApiClient.fetchTransactions()).thenReturn(getTransactions());
        final SumTransactionDto sumTransactionDto = service.getTotals();
        verify(openApiClient).fetchTransactions();
        assertThat(sumTransactionDto.getTransactions()).hasSize(1);
        assertThat(sumTransactionDto.getTotalAmount())
                .isEqualTo(new MonetaryAmount("GBS",  new BigDecimal("520.00")));

    }

    private OpenApiTrans getTransactions() {
        return OpenApiTrans.builder()
                .transactions(singletonList(transaction()))
                .build();
    }

    private OpenApiTransaction transaction() {
        return OpenApiTransaction.builder()
                .id("545454544545klsasae-aasa")
                .details(Details.builder()
                        .type("SEPA")
                        .description("BB Transfer")
                        .value(Value.builder()
                                .amount("520.00")
                                .currency("GBS").build()
                        ).build())
                .this_account(Account.builder()
                        .id("554455")
                        .build())
                .build();
    }
}
