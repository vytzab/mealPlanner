package lt.vytzab.mealPlanner.service;

import lt.vytzab.mealPlanner.dto.MealPlanDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MealPlanService {
    MealPlanDTO addMealPlan(MealPlanDTO mealPlanDTO);
    List<MealPlanDTO> getAllMealPlans();
    ResponseEntity<MealPlanDTO> getMealPlan(Integer id);
    MealPlanDTO updateMealPlan(Integer id, MealPlanDTO mealPlanDTO);
    ResponseEntity<MealPlanDTO> deleteMealPlan(Integer id);
}
