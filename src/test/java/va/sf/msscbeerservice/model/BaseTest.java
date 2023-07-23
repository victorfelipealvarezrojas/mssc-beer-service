package va.sf.msscbeerservice.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import va.sf.msscbeerservice.web.model.BeerDto;
import va.sf.msscbeerservice.web.model.BeerStyleEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    BeerDto getDto(){
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("BeerName")
                .beerStyle(BeerStyleEnum.LAGER)
                .price(new BigDecimal(12.99))
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .upc("123123123123")
                .myLocalDate(LocalDate.now())
                .build();
    }
}
