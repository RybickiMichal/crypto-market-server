package pl.jvng.cryptomarketserver.model;

import lombok.Value;

@Value
public class Crypto {
    private String name;
    private String dataSourceUrl;
}
