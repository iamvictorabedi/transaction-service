package com.bring.transaction.client.openapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "open-api", url = "${open.api.url}")
public interface OpenApiClient {

    @GetMapping("obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions")
    OpenApiTrans fetchTransactions();
}
