package pl.jvng.cryptomarketserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.jvng.cryptomarketserver.service.CryptoService;

@EnableScheduling
@SpringBootApplication
@Slf4j
public class CryptoMarketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoMarketServerApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(CryptoService cryptoService){
        return args -> cryptoService.addMockedCryptos();
    }
}
