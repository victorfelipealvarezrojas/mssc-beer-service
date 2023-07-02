package va.sf.msscbeerservice.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;


@Entity
public class Beer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    private String beerName;

    private String beerStyle;

    @Column(unique = true)
    private String upc;

    private BigDecimal price;

    private Integer minOnHand;

    private Integer quantityToBrew;

    public Beer(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String beerName, String beerStyle, String upc, BigDecimal price, Integer minOnHand, Integer quantityToBrew) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.price = price;
        this.minOnHand = minOnHand;
        this.quantityToBrew = quantityToBrew;
    }

    public static BeerBuilder builder() {
        return new BeerBuilder();
    }

    public UUID getId() {
        return this.id;
    }

    public Long getVersion() {
        return this.version;
    }

    public Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public String getBeerName() {
        return this.beerName;
    }

    public String getBeerStyle() {
        return this.beerStyle;
    }

    public String getUpc() {
        return this.upc;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public Integer getMinOnHand() {
        return this.minOnHand;
    }

    public Integer getQuantityToBrew() {
        return this.quantityToBrew;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public void setBeerStyle(String beerStyle) {
        this.beerStyle = beerStyle;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMinOnHand(Integer minOnHand) {
        this.minOnHand = minOnHand;
    }

    public void setQuantityToBrew(Integer quantityToBrew) {
        this.quantityToBrew = quantityToBrew;
    }

    public static class BeerBuilder {
        private UUID id;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private String beerName;
        private String beerStyle;
        private String upc;
        private BigDecimal price;
        private Integer minOnHand;
        private Integer quantityToBrew;

        public BeerBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public BeerBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public BeerBuilder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public BeerBuilder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public BeerBuilder beerName(String beerName) {
            this.beerName = beerName;
            return this;
        }

        public BeerBuilder beerStyle(String beerStyle) {
            this.beerStyle = beerStyle;
            return this;
        }

        public BeerBuilder upc(String upc) {
            this.upc = upc;
            return this;
        }

        public BeerBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public BeerBuilder minOnHand(Integer minOnHand) {
            this.minOnHand = minOnHand;
            return this;
        }

        public BeerBuilder quantityToBrew(Integer quantityToBrew) {
            this.quantityToBrew = quantityToBrew;
            return this;
        }

        public Beer build() {
            return new Beer(this.id, this.version, this.createdDate, this.lastModifiedDate, this.beerName, this.beerStyle, this.upc, this.price, this.minOnHand, this.quantityToBrew);
        }

        public String toString() {
            return "Beer.BeerBuilder(id=" + this.id + ", version="
                    + this.version + ", createdDate="
                    + this.createdDate + ", lastModifiedDate="
                    + this.lastModifiedDate + ", beerName="
                    + this.beerName + ", beerStyle="
                    + this.beerStyle + ", upc="
                    + this.upc + ", price="
                    + this.price + ", minOnHand="
                    + this.minOnHand + ", quantityToBrew="
                    + this.quantityToBrew + ")";
        }
    }
}
