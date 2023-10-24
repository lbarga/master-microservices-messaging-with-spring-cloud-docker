package io.github.springcloud.mscreditevaluator.infra.clients;

import io.github.springcloud.mscreditevaluator.domain.CustomerCreditCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mscreditcards", path = "/credit-cards")
public interface CreditCardsResourceClient {
    @GetMapping(params = "cpf")
    ResponseEntity<List<CustomerCreditCard>> getCreditCardsByCustomerCpf(@RequestParam String cpf);
}
