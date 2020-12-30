package com.bring.transaction.dto;

import java.math.BigDecimal;

import com.bring.transaction.helper.MonetaryAmount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumTransactionDtoTest {

    @Test
    void toStringValues() {
        final SumTransactionDto transaction = SumTransactionDto
                                .builder()
                                .totalAmount(new MonetaryAmount("GBS", new BigDecimal(25440)))
                                .build();
        assertThat(transaction.toString())
                .hasToString("SumTransactionDto(totalAmount=MonetaryAmount(currency=GBS, amount=25440), transactions=null)");
    }
}
