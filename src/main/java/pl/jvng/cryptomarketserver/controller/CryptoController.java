package pl.jvng.cryptomarketserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jvng.cryptomarketserver.model.Crypto;
import pl.jvng.cryptomarketserver.service.CryptoService;

@AllArgsConstructor
@RequestMapping("crypto")
@RestController
public class CryptoController {

    private final CryptoService cryptoService;

    @PostMapping()
    public ResponseEntity<?> addCrypto(Crypto crypto) {
        return cryptoService.addCrypto(crypto);
    }
}
