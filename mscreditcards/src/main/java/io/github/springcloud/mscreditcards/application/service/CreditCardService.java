package io.github.springcloud.mscreditcards.application.service;

import io.github.springcloud.mscreditcards.domain.CreditCard;
import io.github.springcloud.mscreditcards.domain.CreditCardNetwork;
import io.github.springcloud.mscreditcards.infra.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;

    @Transactional
    public CreditCard saveCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public List<CreditCard> getCreditCardsIncomeLessThan(Long income) {
        var incomeBigDecimal = BigDecimal.valueOf(income);

        return creditCardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }

}
