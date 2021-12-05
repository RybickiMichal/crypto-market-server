package pl.jvng.cryptomarketserver.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Value
public class CryptoPrice {
    private Crypto crypto;
    private LocalDate date;
    private BigDecimal price;
    private BigDecimal marketCap;
    private BigDecimal volume;
    private BigDecimal low;
    private BigDecimal high;

}
