package pl.jvng.cryptomarketserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CryptoPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Crypto crypto;
    private LocalDateTime time;
    private BigDecimal price;
    private BigDecimal marketCap;
    private BigDecimal volume;
    private BigDecimal low;
    private BigDecimal high;

    public CryptoPrice(Crypto crypto, LocalDateTime time, BigDecimal price, BigDecimal marketCap, BigDecimal volume, BigDecimal low, BigDecimal high) {
        this.crypto = crypto;
        this.time = time;
        this.price = price;
        this.marketCap = marketCap;
        this.volume = volume;
        this.low = low;
        this.high = high;
    }
}
