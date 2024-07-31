package momo;

import lombok.Data;

@Data
public class Ingredient {
    private String id;
    private String name;
    private Type type;

    public enum Type {
        FILLING, COOKINGSTYLE, SAUCE
    }
}
