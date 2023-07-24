package va.sf.msscbeerservice.services;

import va.sf.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

    BeerDto saveNewBeer(BeerDto beerDto);
}
