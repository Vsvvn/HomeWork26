package vs.recipe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vs.recipe.model.Ingredient;
import vs.recipe.service.IngredientService;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientId(@PathVariable Long id) {
        return ResponseEntity.of(ingredientService.getIngredient(id));
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {

        return ingredientService.addNewIngredient(ingredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.of(ingredientService.editIngredient(id, ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable Long id) {
        return ResponseEntity.of(ingredientService.deleteIngredient(id));
    }

    @GetMapping
    public Map<Long, Ingredient> getAllIngredients() {

        return ingredientService.getAllIngredients();
    }
}


