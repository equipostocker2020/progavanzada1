package programacionAvanzada.recetas.grupo7;

import programacionAvanzada.recetas.grupo7.pojo.Ingrediente;
import programacionAvanzada.recetas.grupo7.pojo.Receta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class OrganizadorRecetas  {

    private static final Logger LOGGER = Logger.getLogger( OrganizadorRecetas.class.getName() );

    public List<Ingrediente> readIngrediente() throws IOException {

        String row;

        List<Ingrediente> ingredienteList = new ArrayList<>();
        BufferedReader file = new BufferedReader(new FileReader("ingrediente.csv"));
        while ((row = file.readLine()) != null) {
            String[] data = row.split(",");

            for (int i = 0; i < data.length; i++) {
                Ingrediente ing = new Ingrediente();
                String[] dataList = data[i].split("\\s+");
                ing.setCantidad(dataList[0]);
                ing.setNombre(dataList[1]);
                ingredienteList.add(ing);
            }
            System.out.println(ingredienteList);
        }
        file.close();
        return ingredienteList;
    }

    public List<Receta> readReceta() throws IOException {

        String row;
        List<Receta> recetaList = new ArrayList<>();
        List<Ingrediente> ingredienteList = null;
        BufferedReader file = new BufferedReader(new FileReader("recetas.csv"));

        while ((row = file.readLine()) != null) {
            Receta receta = new Receta();
            String[] data = row.split(";");

            for (int i = 0; i < data.length; i++) {
                String[] dataList = data[i].split(":");
                String[] ingredientes = dataList[1].split(",");

                ingredienteList = new ArrayList<>();

                for (int j = 0; j < ingredientes.length; j++) {
                    Ingrediente ing = new Ingrediente();
                    String[] ingrediente = ingredientes[j].split("\\s+");
                    ing.setNombre(ingrediente[2]);
                    ing.setCantidad(ingrediente[1]);
                    ingredienteList.add(ing);
                }
                receta.setIngredientes(ingredienteList);
                receta.setRecetas(dataList[0]);
                recetaList.add(receta);
            }
        }
        file.close();
        return recetaList;
    }

    public boolean compareList(List<Ingrediente> list1, List<Receta> list2) {

        for (Receta receta : list2) {
            if (list1.toString().equals(receta.getIngredientes().toString())) {
                LOGGER.info("Con los ingredientes: "
                        + cleanResponse(list1.toString())
                        + " Se puede realizar el plato: "
                        + cleanResponse(receta.getRecetas()));
                return true;
            }
        }
        LOGGER.fine(cleanResponse("Con los ingredientes: ")
                + list1.toString()
                +" no se puede realizar ningun plato.");
        return false;
    }

    private String cleanResponse (String message){
        if (message.contains("[")) {
          String cleanMessage = message.replaceAll("\\[", "");
            return cleanMessage.replaceAll("\\]", "");
        }
        return message;
    }
}
