package lt.vytzab.mealPlanner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealPlanDTO {
    private int id;
    private String name;
    private String week;
    private List<RecipeDTOWithType> meals;
    private int shoppingListId;
}
