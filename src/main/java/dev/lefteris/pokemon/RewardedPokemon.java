package dev.lefteris.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pokemon-bosses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardedPokemon {
    private Integer pokedexNumber;
    private String name;
    private String type1;
    private String type2;
    private String rewardTier;

    // Constructors, Getters and Setters
}