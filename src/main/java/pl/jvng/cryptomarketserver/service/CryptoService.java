package pl.jvng.cryptomarketserver.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.jvng.cryptomarketserver.model.Crypto;
import pl.jvng.cryptomarketserver.repository.CryptoRepository;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class CryptoService {

    private static List<Crypto> cryptos;

    static {
        cryptos = List.of(
                new Crypto("Bitcoin", "https://coinmarketcap.com/currencies/bitcoin/"),
                new Crypto("Ethereum", "https://coinmarketcap.com/currencies/ethereum/"),
                new Crypto("Binance Coin", "https://coinmarketcap.com/currencies/binance-coin/"),
                new Crypto("Tether", "https://coinmarketcap.com/currencies/tether/"),
                new Crypto("Solana", "https://coinmarketcap.com/currencies/solana/"),
                new Crypto("Cardano", "https://coinmarketcap.com/currencies/cardano/")
        );
    }

    private final CryptoRepository cryptoRepository;

    public List<Crypto> getCryptos() {
        return cryptoRepository.findAll();
    }

    public ResponseEntity<?> addCrypto(Crypto crypto) {
        cryptoRepository.save(crypto);
        log.info("Crypto saved to database");
        return ResponseEntity.ok().build();
    }

    public void addMockedCryptos(){
        if(cryptoRepository.findAll().isEmpty()){
            cryptos.forEach(cryptoRepository::save);
        }
    }
}
