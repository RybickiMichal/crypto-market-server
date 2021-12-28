package pl.jvng.cryptomarketserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.jvng.cryptomarketserver.model.Crypto;

import java.util.List;

@AllArgsConstructor
@Repository
public class CryptoRepository {

    private DynamoDBMapper dynamoDBMapper;

    public List<Crypto> findAll() {
        return dynamoDBMapper.scan(Crypto.class, new DynamoDBScanExpression());
    }

    public void save(Crypto crypto) {
        dynamoDBMapper.save(crypto);
    }
}
