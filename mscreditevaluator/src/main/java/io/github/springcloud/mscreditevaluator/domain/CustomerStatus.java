package io.github.springcloud.mscreditevaluator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerStatus {
    private CustomerData customerData;
    private List<CustomerCreditCard> customerCreditCards;
}
