package pl.jvng.cryptomarketserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jvng.cryptomarketserver.model.CryptoPrice;
import pl.jvng.cryptomarketserver.service.CryptoPriceService;

import java.util.List;

@AllArgsConstructor
@RequestMapping("cryptoPrice")
@RestController
public class CryptoPriceController {

    private final CryptoPriceService cryptoPriceService;

    @GetMapping()
    public List<CryptoPrice> getAllCryptoPrices() {
        return cryptoPriceService.fetchAllCryptoPrices();
    }
}
