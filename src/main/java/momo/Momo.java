package momo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Momo {
    @NotNull
    @Size(min = 5, message = "Name must of at least 5 characters long!")
    private String name;

    @NotNull
    @Size(min = 1, message = "At least one ingredient must be selected!")
    private List<Ingredient> ingredients;
}
