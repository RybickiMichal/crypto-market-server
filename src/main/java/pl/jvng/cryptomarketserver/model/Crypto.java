package pl.jvng.cryptomarketserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Crypto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String dataSourceUrl;

    public Crypto(String name, String dataSourceUrl) {
        this.name = name;
        this.dataSourceUrl = dataSourceUrl;
    }
}
