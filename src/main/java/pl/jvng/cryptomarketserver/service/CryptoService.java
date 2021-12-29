package pl.jvng.cryptomarketserver.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.jvng.cryptomarketserver.model.Crypto;
import pl.jvng.cryptomarketserver.model.CryptoPrice;
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
                new Crypto("Solana", "https://coinmarketcap.com/currencies/solana/"),
                new Crypto("Cardano", "https://coinmarketcap.com/currencies/cardano/"),
                new Crypto("ThorChain", "https://coinmarketcap.com/currencies/thorchain/"),
                new Crypto("Chiliz", "https://coinmarketcap.com/currencies/chiliz/"),
                new Crypto("Kadena", "https://coinmarketcap.com/currencies/kadena/"),
                new Crypto("Kucoin Token", "https://coinmarketcap.com/currencies/kucoin-token/"),
                new Crypto("Holo", "https://coinmarketcap.com/currencies/holo/"),
                new Crypto("Curve DAO", "https://coinmarketcap.com/currencies/curve-dao-token/"),
                new Crypto("Arwe ave", "https://coinmarketcap.com/currencies/arweave/"),
                new Crypto("Huobi Token", "https://coinmarketcap.com/currencies/huobi-token/"),
                new Crypto("Dash", "https://coinmarketcap.com/currencies/dash/"),
                new Crypto("Com pound", "https://coinmarketcap.com/currencies/compound/"),
                new Crypto("Celo", "https://coinmarketcap.com/currencies/celo/"),
                new Crypto("Theta Fuel", "https://coinmarketcap.com/currencies/theta-fuel/"),
                new Crypto("VeChain", "https://coinmarketcap.com/currencies/vechain/"),
                new Crypto("Elrond", "https://coinmarketcap.com/currencies/elrond-egld/"),
                new Crypto("Internet Computer", "https://coinmarketcap.com/currencies/internet-computer/"),
                new Crypto("Bitcoin BEP2", "https://coinmarketcap.com/currencies/bitcoin-bep2/"),
                new Crypto("Filecoin", "https://coinmarketcap.com/currencies/filecoin/"),
                new Crypto("Kusama", "https://coinmarketcap.com/currencies/kusama/"),
                new Crypto("eCash", "https://coinmarketcap.com/currencies/ecash/"),
                new Crypto("Fantom", "https://coinmarketcap.com/currencies/fantom/"),
                new Crypto("Monero", "https://coinmarketcap.com/currencies/monero/"),
                new Crypto("Tezos", "https://coinmarketcap.com/currencies/tezos/"),
                new Crypto("Unus Sed Leo", "https://coinmarketcap.com/currencies/unus-sed-leo/"),
                new Crypto("Klatyn", "https://coinmarketcap.com/currencies/klaytn/"),
                new Crypto("Gala", "https://coinmarketcap.com/currencies/gala/"),
                new Crypto("The Graph", "https://coinmarketcap.com/currencies/the-graph/"),
                new Crypto("Helium", "https://coinmarketcap.com/currencies/helium/"),
                new Crypto("Iota", "https://coinmarketcap.com/currencies/iota/"),
                new Crypto("EOS", "https://coinmarketcap.com/currencies/eos/"),
                new Crypto("Pancake SWAP", "https://coinmarketcap.com/currencies/pancakeswap/"),
                new Crypto("Loop RIng", "https://coinmarketcap.com/currencies/loopring/")
        );
    }

    private final CryptoRepository cryptoRepository;

    public List<Crypto> getCryptos() {
        return cryptoRepository.findAll();
    }

    public ResponseEntity<?> addCrypto(Crypto crypto) {
        cryptoRepository.save(crypto);
        log.info("Crypto {} saved to database", crypto.getName());
        return ResponseEntity.ok().build();
    }

    public void addMockedCryptos(){
        if(cryptoRepository.findAll().isEmpty()){
            cryptos.forEach(cryptoRepository::save);
        }
    }
}
