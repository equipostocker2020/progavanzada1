package programacionAvanzada.recetas.grupo7.main;

import programacionAvanzada.recetas.grupo7.pojo.InterfaceGrafica.Marco;

import javax.swing.JFrame;


public class Main {

    public static void main (String [ ] args)  {
        Marco marco = new Marco();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
