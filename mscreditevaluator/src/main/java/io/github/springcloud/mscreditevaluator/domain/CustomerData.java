package io.github.springcloud.mscreditevaluator.domain;

import lombok.Data;

@Data
public class CustomerData {
    private Long id;
    private String cpf;
    private String name;
    private Integer age;
}
