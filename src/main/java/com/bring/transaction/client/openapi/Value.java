package com.bring.transaction.client.openapi;

import lombok.Builder;

@Builder
@lombok.Value
public class Value {
    private String currency;
    private String amount;
}
