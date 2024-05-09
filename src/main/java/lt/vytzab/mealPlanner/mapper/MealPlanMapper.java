package lt.vytzab.mealPlanner.mapper;

import lt.vytzab.mealPlanner.dto.MealPlanDTO;
import lt.vytzab.mealPlanner.entity.MealPlan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MealPlanMapper {
    MealPlanMapper INSTANCE = Mappers.getMapper(MealPlanMapper.class);
    MealPlan mapMealPlanDTOToMealPlan(MealPlanDTO recipeDTO);
    MealPlanDTO mapMealPlanToMealPlanDTO(MealPlan recipe);
}