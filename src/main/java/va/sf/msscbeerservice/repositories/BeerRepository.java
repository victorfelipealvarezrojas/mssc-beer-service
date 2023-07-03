package va.sf.msscbeerservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import va.sf.msscbeerservice.domain.Beer;
import org.springframework.data.domain.Pageable;
import va.sf.msscbeerservice.web.model.BeerStyleEnum;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

    Beer findByUpc(String upc);

    void save(Beer beer);

}
