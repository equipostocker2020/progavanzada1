package programacionAvanzada.recetas.grupo7;

import programacionAvanzada.recetas.grupo7.pojo.Ingrediente;
import programacionAvanzada.recetas.grupo7.pojo.Receta;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrganizadorRecetas  {

    private static final Logger LOGGER = Logger.getLogger( OrganizadorRecetas.class.getName() );

    public List<Ingrediente> readIngrediente(JTextArea areaTexto) throws IOException {

        String row;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File archivo = fileChooser.getSelectedFile();
        List<Ingrediente> ingredienteList = new ArrayList<>();

            FileReader fileReader = new FileReader(archivo);
            BufferedReader file = new BufferedReader(fileReader);
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
        areaTexto.append("\n"+"Lista de ingredientes: " +"\n"+ingredienteList.toString()+"\n");
        return ingredienteList;
    }

    public List<Receta> readReceta(JTextArea areaTexto) throws IOException {

        String row;

        List<Receta> recetaList = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File archivo = fileChooser.getSelectedFile();
        List<Ingrediente> ingredienteList = new ArrayList<>();

        FileReader fileReader = new FileReader(archivo);
        BufferedReader file = new BufferedReader(fileReader);

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
        areaTexto.append("\n"+"Lista de recetas: "+"\n"+ recetaList.toString()+"\n");
        file.close();
        return recetaList;
    }

    public boolean compareList(List<Ingrediente> list1, List<Receta> list2, JTextArea textArea) {

        for (Receta receta : list2) {
            if (list1.toString().equals(receta.getIngredientes().toString())) {
                textArea.append("\n"+"Con los ingredientes: "
                        + cleanResponse(list1.toString())
                        + " Se puede realizar el plato: "
                        + cleanResponse(receta.getRecetas()));
                return true;
            }
        }
        textArea.append(cleanResponse("\n"+"Con los ingredientes: ")
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
