package vs.recipe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String app() {
        return "Приложение запущено!";
    }

    @GetMapping("/info")
    public String appInfo() {
        return "Сясин Владимир, Recipes, 18.01.23, Приложение для кулинарных рецептов.";
    }
}