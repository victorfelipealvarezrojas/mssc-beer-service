package va.sf.msscbeerservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.*;
import lombok.Data;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class BeerDto {
    static final long serialVersionUID = -5815566940065181210L;
    @JsonProperty("beerId")
    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    @Size(min = 3, max = 100)
    private String beerName;

    @NotNull
    private BeerStyleEnum beerStyle;

    @NotNull
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    @NotNull
    private BigDecimal price;

    private Integer quantityOnHand;

    @JsonSerialize(using = LocalDataSerializer.class)
    @JsonDeserialize(using = LocalDataDeserializer.class)
    private LocalDate myLocalDate;

    public BeerDto(
            @Null UUID id, @Null Integer version, @Null OffsetDateTime createdDate,
            @Null OffsetDateTime lastModifiedDate, @NotBlank String beerName, @NotNull BeerStyleEnum beerStyle,
            @NotNull String upc, @Positive @NotNull BigDecimal price, Integer quantityOnHand, LocalDate myLocalDate)
    {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.price = price;
        this.quantityOnHand = quantityOnHand;
        this.myLocalDate = myLocalDate;
    }

    public static BeerDtoBuilder builder() {
        return new BeerDtoBuilder();
    }

    public static class BeerDtoBuilder {
        private @Null UUID id;
        private @Null Integer version;
        private @Null OffsetDateTime createdDate;
        private @Null OffsetDateTime lastModifiedDate;
        private @NotBlank @Size(min = 3, max = 100) String beerName;
        private @NotNull BeerStyleEnum beerStyle;
        private @NotNull String upc;
        private @Positive @NotNull BigDecimal price;
        private Integer quantityOnHand;
        private LocalDate myLocalDate;

        public BeerDtoBuilder id(@Null UUID id) {
            this.id = id;
            return this;
        }

        public BeerDtoBuilder version(@Null Integer version) {
            this.version = version;
            return this;
        }

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
        public BeerDtoBuilder createdDate(@Null OffsetDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
        public BeerDtoBuilder lastModifiedDate(@Null OffsetDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public BeerDtoBuilder beerName(@NotBlank @Size(min = 3, max = 100) String beerName) {
            this.beerName = beerName;
            return this;
        }

        public BeerDtoBuilder beerStyle(@NotNull BeerStyleEnum beerStyle) {
            this.beerStyle = beerStyle;
            return this;
        }

        public BeerDtoBuilder upc(@NotNull String upc) {
            this.upc = upc;
            return this;
        }

        @JsonFormat(shape = JsonFormat.Shape.STRING)
        public BeerDtoBuilder price(@Positive @NotNull BigDecimal price) {
            this.price = price;
            return this;
        }

        public BeerDtoBuilder quantityOnHand(Integer quantityOnHand) {
            this.quantityOnHand = quantityOnHand;
            return this;
        }

        @JsonFormat(shape = JsonFormat.Shape.STRING)
        @JsonSerialize(using = LocalDataSerializer.class)
        @JsonDeserialize(using = LocalDataDeserializer.class)
        public BeerDtoBuilder myLocalDate(LocalDate myLocalDate) {
            this.myLocalDate = myLocalDate;
            return this;
        }

        public BeerDto build() {
            return new BeerDto(
                    this.id, this.version, this.createdDate,
                    this.lastModifiedDate, this.beerName,
                    this.beerStyle, this.upc, this.price,
                    this.quantityOnHand,
                    this.myLocalDate
            );
        }

        public String toString() {
            return  this.id
                    + ", version=" + this.version
                    + ", createdDate=" + this.createdDate
                    + ", lastModifiedDate=" + this.lastModifiedDate
                    + ", beerName=" + this.beerName
                    + ", beerStyle=" + this.beerStyle
                    + ", upc=" + this.upc
                    + ", price=" + this.price
                    + ", quantityOnHand=" + this.quantityOnHand
                    + ", myLocalDate=" + this.myLocalDate;
        }
    }
}
