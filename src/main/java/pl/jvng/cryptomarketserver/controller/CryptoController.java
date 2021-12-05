package pl.jvng.cryptomarketserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jvng.cryptomarketserver.model.CryptoPrice;
import pl.jvng.cryptomarketserver.repository.CryptoRepository;
import pl.jvng.cryptomarketserver.service.CryptoDataService;

import java.util.List;

@AllArgsConstructor
@RequestMapping("crypto")
@RestController
public class CryptoController {

    private CryptoDataService cryptoDataService;

    @GetMapping()
    public List<CryptoPrice> getAllCryptoPrices() {
        return cryptoDataService.fetchCryptoPrices(CryptoRepository.getCryptos());
    }
}
