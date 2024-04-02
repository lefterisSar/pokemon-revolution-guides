package dev.lefteris.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rewards {
    private String pokedexEntry;
    private RewardedPokemon pokemonRewarded;
    private List<String> accessTo;

}