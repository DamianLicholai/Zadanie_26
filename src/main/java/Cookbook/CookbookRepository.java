package Cookbook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CookbookRepository extends JpaRepository<CookingRecipe, Long> {
}
