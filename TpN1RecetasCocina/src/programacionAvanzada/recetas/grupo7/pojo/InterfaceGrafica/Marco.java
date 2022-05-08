package programacionAvanzada.recetas.grupo7.pojo.InterfaceGrafica;

import programacionAvanzada.recetas.grupo7.OrganizadorRecetas;
import programacionAvanzada.recetas.grupo7.pojo.Ingrediente;
import programacionAvanzada.recetas.grupo7.pojo.Receta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class Marco extends JFrame {

    public Marco(){
        setTitle("Trabajo páctico N°1");
        setBounds(700, 333, 400, 300);
        Lamina miLamina = new Lamina();
        add(miLamina);
    }
}
class Lamina extends JPanel {
    JButton botonRecetas = new JButton("recetas");
    JButton botonIngredientes = new JButton("Ingredientes");
    JTextArea areaTexto = new JTextArea(12, 30);

    List<Receta> listReceta;
    List<Ingrediente> listIngredientes;

    JButton compare = new JButton("Compare");
    public Lamina() {
        add(botonRecetas);
        add(botonIngredientes);
        areaTexto.setLineWrap(true);
        add(areaTexto);
        add(compare);
        botonRecetas.addActionListener(this::buscarRecetas);
        botonIngredientes.addActionListener(this::buscarIngredientes);
        compare.addActionListener(this::compareRecetas);
    }
    private void buscarIngredientes(ActionEvent evt) {
        OrganizadorRecetas organizadorRecetas = new OrganizadorRecetas();
        try {
            listIngredientes = organizadorRecetas.readIngrediente(areaTexto);
        }catch (IOException e){

        }
    }

    private void buscarRecetas(ActionEvent evt){
        OrganizadorRecetas organizadorRecetas = new OrganizadorRecetas();
        try {
            listReceta = organizadorRecetas.readReceta(areaTexto);
        }catch (IOException e){

        }
    }

    private void compareRecetas(ActionEvent evt){
        OrganizadorRecetas organizadorRecetas = new OrganizadorRecetas();
        organizadorRecetas.compareList(listIngredientes, listReceta, areaTexto);
    }


}

