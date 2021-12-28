package pl.jvng.cryptomarketserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.jvng.cryptomarketserver.model.CryptoPrice;

import java.util.List;

@AllArgsConstructor
@Repository
public class CryptoPriceRepository {

    private DynamoDBMapper dynamoDBMapper;

    public List<CryptoPrice> saveAll(List<CryptoPrice> cryptoPrices) {
        cryptoPrices.forEach(cryptoPrice -> dynamoDBMapper.save(cryptoPrice));
        return cryptoPrices;
    }
}
