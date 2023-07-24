package va.sf.msscbeerservice.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import va.sf.msscbeerservice.web.model.BeerDto;

@JsonTest
public class BeerDtoTest extends BaseTest{

    @Test
    void testSerializeDto() throws Exception {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws Exception {
        String json = "{" +
                    "\"beerId\":\"c0d9d3c0-8e6e-4a1e-8e0a-5e2e9a5d3c3e\"," +
                    "\"version\":null," +
                    "\"createdDate\":\"2019-06-03T21:01:53.628287-04:00\"," +
                    "\"lastModifiedDate\":\"2019-06-03T21:01:53.628287-04:00\"," +
                    "\"beerName\":\"BeerName\"," +
                    "\"beerStyle\":\"LAGER\"," +
                    "\"upc\":\"123123123123\"," +
                    "\"price\":12.99," +
                    "\"myLocalDate\":\"20190603\"," +
                    "\"quantityOnHand\":null" +
                "}";

        // BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        // System.out.println(dto);
    }
}
