package io.github.springcloud.mscustomers.application;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.springcloud.mscustomers.application.dto.CustomerSaveRequest;
import io.github.springcloud.mscustomers.application.service.CustormersService;
import io.github.springcloud.mscustomers.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomersController {

    private final CustormersService custormersService;

    @GetMapping("/status")
    public String status() {
        log.info("===return status ok===");
        return "mscustomers/ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CustomerSaveRequest request) {
        Customer customer = request.toModel();

        var currentCustomer = custormersService.saveCustomer(customer);

        if (currentCustomer != null) {
            URI headerLocation = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .query("cpf={cpf}")
                    .buildAndExpand(customer.getCpf())
                    .toUri();

            return ResponseEntity.created(headerLocation).build();
        }

        return ResponseEntity.internalServerError().build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getByCpf(@RequestParam("cpf") String cpf) {
        var customer = custormersService.getByCpf(cpf);

        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        var customers = custormersService.getAllCustomers();

        return ResponseEntity.ok(customers);
    }
}
