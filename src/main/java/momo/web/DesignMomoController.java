package momo.web;

import lombok.extern.slf4j.Slf4j;
import momo.Ingredient;
import momo.Ingredient.Type;
import momo.Momo;
import momo.MomoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("momoOrder")
public class DesignMomoController {
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("BUF", "Buff Momo", Type.FILLING),
                new Ingredient("CHI", "Chicken Momo", Type.FILLING),
                new Ingredient("VEG", "Vegetable Momo", Type.FILLING),
                new Ingredient("MUT", "Mutton Momo", Type.FILLING),
                new Ingredient("STEAM", "Steamed",  Type.COOKINGSTYLE),
                new Ingredient("CHILL", "Chilly", Type.COOKINGSTYLE),
                new Ingredient("FRIED", "Fried",  Type.COOKINGSTYLE),
                new Ingredient("TOMATO", "Tomato Sauce", Type.SAUCE),
                new Ingredient("CHILLY", "Red Chilly Sauce", Type.SAUCE),
                new Ingredient("SESAME", "Sesame Sauce", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "momoOrder")
    public MomoOrder order() {
        return new MomoOrder();
    }

    @ModelAttribute(name = "momo")
    public Momo momo() {
        return new Momo();
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @GetMapping
    public String showDesignForm() {
        return "design.html";
    }

    @PostMapping
    public String processMomo(Momo momo, @ModelAttribute MomoOrder momoOrder) {
        momoOrder.addMomo(momo);
        log.info("Processing momo: {}", momo);

        return "redirect:/orders/current";
    }
}
