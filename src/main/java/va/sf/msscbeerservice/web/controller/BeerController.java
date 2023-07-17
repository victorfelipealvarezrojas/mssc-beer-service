package va.sf.msscbeerservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import va.sf.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class BeerController {

    @GetMapping("beer/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId,
            @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand){
        if (showInventoryOnHand == null) showInventoryOnHand = false;

        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @GetMapping("param")//http://localhost:8080/api/v1/param?beerId=123
    public ResponseEntity<String> getBeerID(@RequestParam(value = "beerId", defaultValue ="beerId" ) String id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("beerUpc/{upc}")
    public ResponseEntity<BeerDto> getBeerByUpc(@PathVariable("upc") String upc){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping(path = "beer")
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.CREATED);
    }

    @PutMapping("beer/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.NO_CONTENT);
    }
}
