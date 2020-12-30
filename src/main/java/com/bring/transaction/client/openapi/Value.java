package com.bring.transaction.client.openapi;

import java.util.Currency;

import lombok.Getter;

@Getter
public class Value {
    private Currency currency;
    private String amount;
}
