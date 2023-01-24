package vs.recipe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vs.recipe.model.Recipe;
import vs.recipe.service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeId(@PathVariable Long id) {
        return ResponseEntity.of(recipeService.getRecipe(id));
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {

        return recipeService.addNewRecipe(recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return ResponseEntity.of(recipeService.edit(id, recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable Long id) {
        return ResponseEntity.of(recipeService.delete(id));
    }

    @GetMapping
    public Map<Long, Recipe> getAllRecipes() {

        return recipeService.getAll();
    }
}
