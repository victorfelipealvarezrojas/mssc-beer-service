package va.sf.msscbeerservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class BeerDto {
    static final long serialVersionUID = -5815566940065181210L;

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

    public BeerDto(
            @Null UUID id, @Null Integer version, @Null OffsetDateTime createdDate,
            @Null OffsetDateTime lastModifiedDate, @NotBlank String beerName, @NotNull BeerStyleEnum beerStyle,
            @NotNull String upc, @Positive @NotNull BigDecimal price, Integer quantityOnHand)
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
    }

    public static BeerDtoBuilder builder() {
        return new BeerDtoBuilder();
    }

    public static class BeerDtoBuilder {
        private @Null UUID id;
        private @Null Integer version;
        private @Null OffsetDateTime createdDate;
        private @Null OffsetDateTime lastModifiedDate;
        private @NotBlank String beerName;
        private @NotNull BeerStyleEnum beerStyle;
        private @NotNull String upc;
        private @Positive @NotNull BigDecimal price;
        private Integer quantityOnHand;

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

        public BeerDtoBuilder beerName(@NotBlank String beerName) {
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

        public BeerDto build() {
            return new BeerDto(
                    this.id, this.version, this.createdDate,
                    this.lastModifiedDate, this.beerName,
                    this.beerStyle, this.upc, this.price,
                    this.quantityOnHand
            );
        }

        public String toString() {
            return "BeerDto.BeerDtoBuilder(id="
                    + this.id + ", version="
                    + this.version + ", createdDate="
                    + this.createdDate + ", lastModifiedDate="
                    + this.lastModifiedDate + ", beerName="
                    + this.beerName + ", beerStyle="
                    + this.beerStyle + ", upc="
                    + this.upc + ", price="
                    + this.price + ", quantityOnHand="
                    + this.quantityOnHand
                    + ")";
        }
    }
}
