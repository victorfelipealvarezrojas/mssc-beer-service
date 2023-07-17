package va.sf.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;
import va.sf.msscbeerservice.domain.Beer;
import va.sf.msscbeerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
