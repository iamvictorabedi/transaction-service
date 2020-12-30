package com.bring.transaction.helper;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static java.util.Objects.nonNull;

/**
 * MonetaryAmount
 **/
@Getter
@ToString
@EqualsAndHashCode
public class MonetaryAmount {
    private final String currency;

    private final BigDecimal amount;

    @Builder
    public MonetaryAmount(final String currency, final BigDecimal amount) {
        this.currency = currency;
        this.amount = nonNull(amount) ? amount: BigDecimal.ZERO;
    }
}
