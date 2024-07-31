package momo;

import lombok.Data;

import java.util.List;

@Data
public class Momo {
    private String name;

    private List<Ingredient> ingredients;
}
