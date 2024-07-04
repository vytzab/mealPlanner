package lt.vytzab.mealPlanner.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.vytzab.mealPlanner.dto.RecipeDTOWithType;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String week;
    @ElementCollection
    @CollectionTable(name = "mealplan_recipe_mapping", joinColumns = @JoinColumn(name = "mealplan_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "recipeId", column = @Column(name = "recipe_id")),
            @AttributeOverride(name = "type", column = @Column(name = "type")),
            @AttributeOverride(name = "day", column = @Column(name = "day"))  // New day attribute
    })
    private List<RecipeDTOWithType> meals;
    private int shoppingListId;
}