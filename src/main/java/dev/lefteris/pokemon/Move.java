package dev.lefteris.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pokemon-bosses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Move {

    private String name;
    private String type;
    private String category;
    private Integer basePower;
    private Integer accuracy;

    // Constructors, Getters and Setters
}