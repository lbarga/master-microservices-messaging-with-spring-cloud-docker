package io.github.springcloud.mscreditevaluator.application;

import io.github.springcloud.mscreditevaluator.application.exceptions.CustomerDataNotFoundException;
import io.github.springcloud.mscreditevaluator.application.exceptions.ErrorCommunicationMicroservicesException;
import io.github.springcloud.mscreditevaluator.application.service.CreditEvaluatorService;
import io.github.springcloud.mscreditevaluator.domain.CustomerStatus;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-evaluator")
@RequiredArgsConstructor
public class CreditEvaluatorController {
    private final CreditEvaluatorService creditEvaluatorService;

    @GetMapping("/status")
    public String status() {
        return "mscreditevaluator/ok";
    }

    @GetMapping(value = "/evaluate", params = "cpf")
    public ResponseEntity evaluateCustomerStatus(@RequestParam String cpf)
            throws CustomerDataNotFoundException, ErrorCommunicationMicroservicesException
    {
        try{
            CustomerStatus customerStatus = creditEvaluatorService.getCustomerStatus(cpf);

            return ResponseEntity.ok(customerStatus);
        }catch (CustomerDataNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (ErrorCommunicationMicroservicesException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
    }
}
