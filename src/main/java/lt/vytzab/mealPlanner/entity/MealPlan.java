package lt.vytzab.mealPlanner.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.vytzab.mealPlanner.dto.RecipeDTOWithType;

import java.time.LocalDate;
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

    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @ElementCollection
    @CollectionTable(name = "mealplan_recipe_mapping", joinColumns = @JoinColumn(name = "mealplan_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "recipeId", column = @Column(name = "recipe_id")),
            @AttributeOverride(name = "type", column = @Column(name = "type")),
            @AttributeOverride(name = "day", column = @Column(name = "day")),
            @AttributeOverride(name = "person", column = @Column(name = "person"))
    })

    private List<RecipeDTOWithType> meals;

    private int shoppingListId;
}