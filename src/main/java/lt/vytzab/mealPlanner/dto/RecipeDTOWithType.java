package lt.vytzab.mealPlanner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTOWithType {
    private int recipeId;
    private String type; //breakfast , lunch , dinner
}