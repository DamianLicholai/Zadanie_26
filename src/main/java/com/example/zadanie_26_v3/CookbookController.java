package com.example.zadanie_26_v3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class CookbookController {

    private CookbookRepository cookbookRepository;

    public CookbookController(CookbookRepository cookbookRepository) {
        this.cookbookRepository = cookbookRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public String showCookingRecipeList(Model model, @RequestParam(required = false, name = "kategoria") Category category) {
        List<CookingRecipe> cookingRecipes;

        if (category != null) {
            cookingRecipes = cookbookRepository.findByCategory(category);
        } else {
            cookingRecipes = cookbookRepository.findAll();
        }
        model.addAttribute("cookingRecipes", cookingRecipes);
        return "list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        CookingRecipe cookingRecipe = new CookingRecipe();
        model.addAttribute("cookingRecipe", cookingRecipe);
        return "cookingRecipeAdd";
    }

    @PostMapping("/add")
    public String add(CookingRecipe cookingRecipe) {
        cookbookRepository.save(cookingRecipe);
        return "redirect:/list";
    }

    @GetMapping("/cookingRecipes/{id}")
    public String showCookingRecipe(@PathVariable Long id, Model model) {
        Optional<CookingRecipe> optionalCookingRecipe = cookbookRepository.findById(id);
        if (optionalCookingRecipe.isPresent()) {
            CookingRecipe cookingRecipe = optionalCookingRecipe.get();
            model.addAttribute("cookingRecipe", cookingRecipe);
            return "cookingRecipe";
        }
        return "redirect:/";
    }

    @GetMapping("/cookingRecipe/{id}/edit")
    public String editCookingRecipe(@PathVariable Long id, Model model) {
        Optional<CookingRecipe> optionalCookingRecipe = cookbookRepository.findById(id);
        if (optionalCookingRecipe.isPresent()) {
            CookingRecipe cookingRecipeToEdit = optionalCookingRecipe.get();
            model.addAttribute("cookingRecipeToEdit", cookingRecipeToEdit);
            return "cookingRecipeEdit";
        }
        return "redirect:/";
    }

    @GetMapping("/cookingRecipe/{id}/likeIt")
    public String addLikeToCookingRecipe(@PathVariable Long id, Model model) {
        Optional<CookingRecipe> optionalCookingRecipe = cookbookRepository.findById(id);

        if (optionalCookingRecipe.isPresent()) {
            CookingRecipe cookingRecipe = optionalCookingRecipe.get();
            cookingRecipe.setLikeNumber(cookingRecipe.getLikeNumber() + 1);
            cookbookRepository.save(cookingRecipe);

            model.addAttribute("cookingRecipe", cookingRecipe);
            return "cookingRecipe";
        }
        return "redirect:/";
    }

    @GetMapping("/cookingRecipe/{id}/delete")
    public String deleteCookingRecipe(@PathVariable Long id, Model model) {
        Optional<CookingRecipe> optionalCookingRecipe = cookbookRepository.findById(id);
        if (optionalCookingRecipe.isPresent()) {
            CookingRecipe cookingRecipeToEdit = optionalCookingRecipe.get();
            cookbookRepository.delete(cookingRecipeToEdit);
//            model.addAttribute("cookingRecipeToEdit", cookingRecipeToEdit);
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping("/listTop")
    public String topCookingRecipes(Model model) {
        List<CookingRecipe> cookingRecipes = cookbookRepository.findTop4ByOrderByLikeNumberDesc();
        model.addAttribute("cookingRecipes", cookingRecipes);
        return "TopCookingRecipes";
    }

}
