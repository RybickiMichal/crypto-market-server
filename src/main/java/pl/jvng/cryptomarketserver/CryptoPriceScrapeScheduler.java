package pl.jvng.cryptomarketserver;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.jvng.cryptomarketserver.model.CryptoPrice;
import pl.jvng.cryptomarketserver.service.CryptoPriceService;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Component
class CryptoPriceScrapeScheduler {

    private final CryptoPriceService cryptoPriceService;

    @Scheduled(fixedDelay = 5000)
    public void scheduleCryptoPriceScraping() {
        List<CryptoPrice> cryptoPrices = cryptoPriceService.fetchAllCryptoPrices();
        log.info("Number of prices fetched: {}", cryptoPrices.size());
        cryptoPriceService.saveCryptoPricesToDatabase(cryptoPrices);
        log.info("Crypto prices saved to database");
    }
}
