package momo.web;

import momo.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import momo.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("BUF", new Ingredient("BUF", "Buff Momo", Type.FILLING));
        ingredientMap.put("CHI", new Ingredient("CHI", "Chicken Momo", Type.FILLING));
        ingredientMap.put("VEG", new Ingredient("VEG", "Vegetable Momo", Type.FILLING));
        ingredientMap.put("MUT", new Ingredient("MUT", "Mutton Momo", Type.FILLING));
        ingredientMap.put("STEAM", new Ingredient("STEAM", "Steamed",  Type.COOKINGSTYLE));
        ingredientMap.put("CHILL", new Ingredient("CHILL", "Chilly", Type.COOKINGSTYLE));
        ingredientMap.put("FRIED", new Ingredient("FRIED", "Fried",  Type.COOKINGSTYLE));
        ingredientMap.put("TOMATO", new Ingredient("TOMATO", "Tomato Sauce", Type.SAUCE));
        ingredientMap.put("CHILLY", new Ingredient("CHILLY", "Red Chilly Sauce", Type.SAUCE));
        ingredientMap.put("SESAME", new Ingredient("SESAME", "Sesame Sauce", Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
