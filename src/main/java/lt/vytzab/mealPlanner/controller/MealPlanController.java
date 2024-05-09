package lt.vytzab.mealPlanner.controller;

import lt.vytzab.mealPlanner.dto.MealPlanDTO;
import lt.vytzab.mealPlanner.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mealplan")
@CrossOrigin
public class MealPlanController {
    @Autowired
    private MealPlanService mealPlanService;

    @PostMapping("/addMealPlan")
    public ResponseEntity<MealPlanDTO> addMealPlan(@RequestBody MealPlanDTO mealPlanDTO) {
        MealPlanDTO savedMealPlan = mealPlanService.addMealPlan(mealPlanDTO);
        return new ResponseEntity<>(savedMealPlan, HttpStatus.CREATED);
    }

    @GetMapping("/getAllMealPlans")
    public ResponseEntity<List<MealPlanDTO>> getAllMealPlans(){
        List<MealPlanDTO> allIngredients = mealPlanService.getAllMealPlans();
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }

    @GetMapping("/getMealPlan/{id}")
    public ResponseEntity<MealPlanDTO> getMealPlan(@PathVariable("id") Integer id) {
        return mealPlanService.getMealPlan(id);
    }

    @PutMapping("/updateMealPlan")
    public ResponseEntity<MealPlanDTO> updateMealPlan(@RequestBody MealPlanDTO mealPlanDTO) {
        MealPlanDTO updatedMealPlanDTO = mealPlanService.updateMealPlan(mealPlanDTO.getId(), mealPlanDTO);
        return new ResponseEntity<>(updatedMealPlanDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMealPlan/{id}")
    public ResponseEntity<MealPlanDTO> deleteMealPlan(@PathVariable("id") Integer id) {
        return mealPlanService.deleteMealPlan(id);
    }
}
