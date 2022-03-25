package co.com.sofka.mentoring35;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RandomRepository extends ReactiveCrudRepository<Coin, String> {
    
}
