package va.sf.msscbeerservice.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;
import va.sf.msscbeerservice.web.model.BeerDto;

@ActiveProfiles("kebab") // this will use the application-snake.properties file
@JsonTest
public class BeerDtoKebabTest extends BaseTest {

    @Test
    void testKebab() throws Exception {
        BeerDto dto = getDto();

        String jsonString = objectMapper.writeValueAsString(dto);

        System.out.println(jsonString);
    }
}
