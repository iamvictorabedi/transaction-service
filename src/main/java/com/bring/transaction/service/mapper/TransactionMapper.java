package com.bring.transaction.service.mapper;

import com.bring.transaction.client.openapi.OpenApiTransaction;
import com.bring.transaction.dto.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionMapper {
    @Mapping(source = "this_account.id", target = "accountId")
    @Mapping(source = "other_account.number", target = "counterpartyAccount")
    @Mapping(source = "other_account.holder.name", target = "counterpartyName")
    @Mapping(source = "other_account.metadata.image_URL", target = "counterPartyLogoPath")
    @Mapping(source = "details.value.amount", target = "instructedAmount")
    @Mapping(source = "details.value.currency", target = "instructedCurrency")
    @Mapping(source = "details.value.amount", target = "transactionAmount")
    @Mapping(source = "details.value.currency", target = "transactionCurrency")
    @Mapping(source = "details.type", target = "transactionType")
    @Mapping(source = "details.description", target = "description")
    TransactionDto toTransactionDto(OpenApiTransaction transaction);
}
