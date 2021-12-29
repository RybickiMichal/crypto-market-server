package pl.jvng.cryptomarketserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
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

    public List<CryptoPrice> findAll() {
        return dynamoDBMapper.scan(CryptoPrice.class, new DynamoDBScanExpression());
    }
}
