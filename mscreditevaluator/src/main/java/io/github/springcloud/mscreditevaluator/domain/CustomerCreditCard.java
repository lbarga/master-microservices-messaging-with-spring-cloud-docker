package io.github.springcloud.mscreditevaluator.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerCreditCard {
    private String name;
    private String creditCardNetwork;
    private BigDecimal approvedCreditLimit;
}
