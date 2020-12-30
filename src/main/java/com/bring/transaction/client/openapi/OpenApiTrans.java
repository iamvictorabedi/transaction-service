package com.bring.transaction.client.openapi;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

/**
 * This class consists of data items fetched from Open Api consisting of a list of
 * @see OpenApiTransaction
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenApiTrans {
    private List<OpenApiTransaction> transactions;
}
