package io.github.springcloud.mscreditcards.infra.repository;

import io.github.springcloud.mscreditcards.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findByIncomeLessThanEqual(BigDecimal incomeBigDecimal);
}
