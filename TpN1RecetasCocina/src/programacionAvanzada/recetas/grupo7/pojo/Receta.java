package programacionAvanzada.recetas.grupo7.pojo;

import java.util.List;

public class Receta {

    private String recetas;
    private List<Ingrediente> ingredientes;

    public String getRecetas() {
        return recetas;
    }

    public Receta setRecetas(String recetas) {
        this.recetas = recetas;
        return this;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public Receta setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
        return this;
    }

    @Override
    public String toString() {
        return ingredientes.toString();
    }
}
