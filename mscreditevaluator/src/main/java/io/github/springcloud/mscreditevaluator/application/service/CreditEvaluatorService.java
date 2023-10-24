package io.github.springcloud.mscreditevaluator.application.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import feign.FeignException;
import io.github.springcloud.mscreditevaluator.application.exceptions.CustomerDataNotFoundException;
import io.github.springcloud.mscreditevaluator.application.exceptions.ErrorCommunicationMicroservicesException;
import io.github.springcloud.mscreditevaluator.domain.CustomerCreditCard;
import io.github.springcloud.mscreditevaluator.domain.CustomerData;
import io.github.springcloud.mscreditevaluator.domain.CustomerStatus;
import io.github.springcloud.mscreditevaluator.infra.clients.CreditCardsResourceClient;
import io.github.springcloud.mscreditevaluator.infra.clients.CustomersResourceClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreditEvaluatorService {

    private final CustomersResourceClient customersResourceClient;
    private final CreditCardsResourceClient creditCardsResourceClient;

    public CustomerStatus getCustomerStatus(String cpf)
            throws CustomerDataNotFoundException, ErrorCommunicationMicroservicesException {
        try {
            ResponseEntity<CustomerData> customerDataResponse = customersResourceClient.getByCpf(cpf);
            ResponseEntity<List<CustomerCreditCard>> customerCreditCardsResponse = creditCardsResourceClient
                    .getCreditCardsByCustomerCpf(cpf);

            return CustomerStatus
                    .builder()
                    .customerData(customerDataResponse.getBody())
                    .customerCreditCards(customerCreditCardsResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (status == HttpStatus.NOT_FOUND.value()) {
                throw new CustomerDataNotFoundException();
            }
            throw new ErrorCommunicationMicroservicesException(e.getMessage(), status);
        }
    }
}
