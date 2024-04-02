package dev.lefteris.pokemon;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.util.List;

@Document(collection = "pokemon-bosses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boss {
    private String name;
    private String region;
    private String location;
    private String cooldown;
    private List<Pokemon> lineup;
    private Rewards rewards;

}

