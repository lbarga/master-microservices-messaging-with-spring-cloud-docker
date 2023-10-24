package io.github.springcloud.mscreditcards.application.dto;


// representation or DTO class

import io.github.springcloud.mscreditcards.domain.CreditCard;
import io.github.springcloud.mscreditcards.domain.CreditCardNetwork;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditCardSaveRequest {

    private String name;
    private CreditCardNetwork creditCardNetwork;
    private BigDecimal income;
    private BigDecimal creditLimit;

    public CreditCard toModel() {
        return new CreditCard(name, creditCardNetwork, income, creditLimit);
    }
}
