package pl.jvng.cryptomarketserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jvng.cryptomarketserver.model.Crypto;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Long> {

}
