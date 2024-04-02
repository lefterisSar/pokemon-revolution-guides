package dev.lefteris.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pokemon-bosses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    private String name;
    private String nature;
    private String ability;
    private String item;
    private List<Move> moves;

}