package com.bring.transaction.client.openapi;

import lombok.Getter;

@Getter
public class Account {
    private String id;
    private String number;
    private Holder holder;
    private  Metadata metadata;
}
