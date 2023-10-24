package io.github.springcloud.mscreditevaluator.infra.clients;

import io.github.springcloud.mscreditevaluator.domain.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mscustomers", path = "/customers")
public interface CustomersResourceClient {
    @GetMapping(params = "cpf")
    ResponseEntity<CustomerData> getByCpf(@RequestParam("cpf") String cpf);
}
