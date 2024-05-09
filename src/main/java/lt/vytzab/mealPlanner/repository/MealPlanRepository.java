package lt.vytzab.mealPlanner.repository;

import lt.vytzab.mealPlanner.entity.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Integer> {
}
