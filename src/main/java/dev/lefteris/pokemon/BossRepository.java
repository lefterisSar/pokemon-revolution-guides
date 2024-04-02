package dev.lefteris.pokemon;

import dev.lefteris.pokemon.Boss;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BossRepository extends MongoRepository<Boss, String> {
    Optional<Boss> findByName(String name);
}