package com.bring.transaction.client.openapi;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Account {
    private String id;
    private String number;
    private Holder holder;
    private  Metadata metadata;
}
