package com.bring.transaction.client.openapi;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/**
 * @implNote This class maps data retrieved from OpenApi and is used while fetching transactions
 */
@Value
@Builder
@Jacksonized
public class OpenApiTransaction {
    String id;
    Account this_account;
    Account other_account;
    Details details;
}
