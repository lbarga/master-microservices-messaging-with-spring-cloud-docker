package io.github.springcloud.mscustomers.application.dto;

import io.github.springcloud.mscustomers.domain.Customer;
import lombok.Data;

// representation or DTO class

@Data
public class CustomerSaveRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Customer toModel() {
        return new Customer(cpf, name, age);
    }
}
