package io.github.springcloud.mscreditcards.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "credit_card")
@Data
@NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private CreditCardNetwork creditCardNetwork;
    @Column
    private BigDecimal income;
    @Column
    private BigDecimal creditLimit;

    public CreditCard(String name,
                      CreditCardNetwork creditCardNetwork,
                      BigDecimal income,
                      BigDecimal creditLimit)
    {
        this.name = name;
        this.creditCardNetwork = creditCardNetwork;
        this.income = income;
        this.creditLimit = creditLimit;
    }
}
