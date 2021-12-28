package pl.jvng.cryptomarketserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jvng.cryptomarketserver.model.CryptoPrice;

@Repository
public interface CryptoPriceRepository extends JpaRepository<CryptoPrice, Long> {}
