package lt.vytzab.mealPlanner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private int id;
    private String name;
    private String description;
    private int preparationTime;
    private int cookingTime;
    private int totalTime;
    private String instructions;
    private int servings;
    private String difficultyLevel;
    private String image;
    private double totalProtein;
    private double totalCarbs;
    private double totalFat;
    private int totalKcal;
}
