package programacionAvanzada.recetas.grupo7.main;

import programacionAvanzada.recetas.grupo7.OrganizadorRecetas;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main (String [ ] args) throws IOException {
        OrganizadorRecetas recetas = new OrganizadorRecetas();
//        recetas.readFile();
//        recetas.readIngrediente();
//        recetas.readReceta();
        recetas.compareList(recetas.readIngrediente(), recetas.readReceta());


    }
}
