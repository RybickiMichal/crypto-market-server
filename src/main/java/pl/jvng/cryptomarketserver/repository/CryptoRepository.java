package pl.jvng.cryptomarketserver.repository;

import pl.jvng.cryptomarketserver.model.Crypto;

import java.util.List;

public class CryptoRepository {
    private static List<Crypto> cryptos;

    static {
        cryptos = List.of(
                new Crypto("Tether", "https://coinmarketcap.com/currencies/tether/"),
                new Crypto("Bitcoin", "https://coinmarketcap.com/currencies/bitcoin/"),
                new Crypto("Ethereum", "https://coinmarketcap.com/currencies/ethereum/"),
                new Crypto("Cardano", "https://coinmarketcap.com/currencies/cardano/")
        );
    }

    public static List<Crypto> getCryptos(){
        return cryptos;
    }

}
