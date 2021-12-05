package pl.jvng.cryptomarketserver.service;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import pl.jvng.cryptomarketserver.model.Crypto;
import pl.jvng.cryptomarketserver.model.CryptoPrice;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class CryptoDataService {

    public CryptoPrice fetchCryptoPrice(Crypto crypto) {
        Document document = initDocument(crypto.getDataSourceUrl());
        return CryptoPrice.builder()
                .crypto(crypto)
                .price(extractPrice(document.getElementsByClass("priceTitle").text()))
                .low(extractPrice(document.getElementsByClass("n78udj-5 dBJPYV").text().split(" ")[0]))
                .high(extractPrice(document.getElementsByClass("n78udj-5 dBJPYV").text().split(" ")[1]))
                .marketCap(extractPrice(document.getElementsByClass("statsValue").text().split(" ")[0]))
                .volume(extractPrice(document.getElementsByClass("statsValue").text().split(" ")[2]))
                .date(LocalDate.now())
                .build();
    }

    public List<CryptoPrice> fetchCryptoPrices(List<Crypto> cryptos) {
        return cryptos.stream()
                .map(this::fetchCryptoPrice)
                .collect(Collectors.toList());
    }

    private Document initDocument(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException exception) {
            log.error("Error during fetching crypto data");
            return null;
        }
    }

    private static BigDecimal extractPrice(String rawPrice) {
        String[] splittedPrice = rawPrice.replace(",", "").substring(1).split("\\.");
        if (splittedPrice.length == 1) {
            return new BigDecimal(splittedPrice[0]);
        }
        return new BigDecimal(splittedPrice[0] + "." + splittedPrice[1]);
    }
}
