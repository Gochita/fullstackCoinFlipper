package co.com.sofka.mentoring35;

import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class CoinController {

    private final RandomRepository randomRepository;
    int numerito= (int)(Math.random()*(2));


    @Autowired
    public CoinController(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @PostMapping("")
    public Mono<Coin> post(@RequestBody RequestDTO request) {
        
        return Mono.just(new Coin()).map(entity -> {
            entity.setDate(new Date());
            entity.setOrginalList(request.getNumeroMonedas());
            return entity;
        }).map(entity -> {

            var list = Stream.of(request.getNumeroMonedas())
                .collect(Collectors.toList()).stream()
                    .map(item ->{
                        item= numerito;
                        return item;
                    }
                    ).collect(Collectors.toList());

            entity.setRandomList(list);
            return entity;
        }).flatMap(randomRepository::save);
    }

    @GetMapping("")
    public Flux<Coin> get() {
        return randomRepository.findAll();
    }
}
