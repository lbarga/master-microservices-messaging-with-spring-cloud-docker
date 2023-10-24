package io.github.springcloud.mscreditcards.application;

import io.github.springcloud.mscreditcards.application.dto.CreditCardSaveRequest;
import io.github.springcloud.mscreditcards.application.service.CreditCardService;
import io.github.springcloud.mscreditcards.domain.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-cards")
@RequiredArgsConstructor
public class CreditCardsController {

    private final CreditCardService creditCardService;

    @GetMapping("/status")
    public String status() {
        return "mscreditcards/ok";
    }

    @PostMapping
    public ResponseEntity saveCreditCard(@RequestBody CreditCardSaveRequest request) {
        CreditCard creditCard = request.toModel();

        var currentCreditCard = creditCardService.saveCreditCard(creditCard);

        if (currentCreditCard != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.internalServerError().build();
    }

    @GetMapping(params = "income")
    public ResponseEntity getCreditCardsIncomeLessThan(@RequestParam Long income) {
        List<CreditCard> creditCards = creditCardService.getCreditCardsIncomeLessThan(income);

        return ResponseEntity.ok(creditCards);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getCreditCardsByCustomerCpf(@RequestParam String cpf) {
        // TODO: implement get credit cards by customer cpf
        List<CreditCard> creditCards = creditCardService.getCreditCardsIncomeLessThan(10000L);

        return ResponseEntity.ok(creditCards);
    }
}
