package com.example.zadanie_26_v3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface CookbookRepository extends JpaRepository<CookingRecipe, Long> {

    List<CookingRecipe> findTop4ByOrderByLikeNumberDesc();


    List<CookingRecipe> findByCategory(Category category);


}
