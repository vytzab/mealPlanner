package lt.vytzab.mealPlanner.service;

import jakarta.ws.rs.NotFoundException;
import lt.vytzab.mealPlanner.dto.MealPlanDTO;
import lt.vytzab.mealPlanner.entity.MealPlan;
import lt.vytzab.mealPlanner.mapper.MealPlanMapper;
import lt.vytzab.mealPlanner.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MealPlanServiceImpl implements MealPlanService{
    @Autowired
    private MealPlanRepository mealPlanRepository;
    @Override
    public MealPlanDTO addMealPlan(MealPlanDTO mealPlanDTO) {
        MealPlan mealPlan = mealPlanRepository.save(MealPlanMapper.INSTANCE.mapMealPlanDTOToMealPlan(mealPlanDTO));
        return MealPlanMapper.INSTANCE.mapMealPlanToMealPlanDTO(mealPlan);
    }

    @Override
    public List<MealPlanDTO> getAllMealPlans() {
        List<MealPlan> mealPlans = mealPlanRepository.findAll();
        return mealPlans.stream().map(MealPlanMapper.INSTANCE::mapMealPlanToMealPlanDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<MealPlanDTO> getMealPlan(Integer id) {
        Optional<MealPlan> optionalMealPlan = mealPlanRepository.findById(id);
        return optionalMealPlan.map(recipe -> new ResponseEntity<>(MealPlanMapper.INSTANCE.mapMealPlanToMealPlanDTO(recipe), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public MealPlanDTO updateMealPlan(Integer id, MealPlanDTO mealPlanDTO) {
        Optional<MealPlan> optionalMealPlan = mealPlanRepository.findById(id);
        if (optionalMealPlan.isEmpty()) {
            throw new NotFoundException("Meal Plan not found with id: " + id);
        }
        MealPlan mealPlan = mealPlanRepository.save(MealPlanMapper.INSTANCE.mapMealPlanDTOToMealPlan(mealPlanDTO));
        return MealPlanMapper.INSTANCE.mapMealPlanToMealPlanDTO(mealPlan);
    }

    @Override
    public ResponseEntity<MealPlanDTO> deleteMealPlan(Integer id) {
        Optional<MealPlan> optionalMealPlan = mealPlanRepository.findById(id);
        if (optionalMealPlan.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mealPlanRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
