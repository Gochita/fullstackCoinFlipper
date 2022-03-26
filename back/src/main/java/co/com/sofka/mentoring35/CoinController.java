package co.com.sofka.mentoring35;

import java.util.Collections;
import java.util.Date;
import java.util.Random;
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


    @Autowired
    public CoinController(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @PostMapping("")
    public Mono<Coin> post() {
        String cara;
        int valorCoin = new Random().nextInt(2);
        switch (valorCoin) {
            case 0:
                cara = "cara";
                break;
            case 1:
                cara = "cruz";
                break;
            default:
                cara = "Imposible";
        }


        return Mono.just(new Coin()).map(entity -> {
            entity.setDate(new Date());
            entity.setResultado(cara);
            return entity;
        }).flatMap(randomRepository::save);
    }

    @GetMapping("")
    public Flux<Coin> get() {
        return randomRepository.findAll();
    }
}
