package com.bring.transaction.client.openapi;

import lombok.Builder;

@Builder
@lombok.Value
public class Details {
    private String type;
    private String description;
    private Value value;
}
