package va.sf.msscbeerservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import va.sf.msscbeerservice.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> { }
