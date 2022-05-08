package programacionAvanzada.recetas.grupo7.pojo;

public class Ingrediente {

    private String nombre;
    private String cantidad;

    public String getNombre() {
        return nombre;
    }

    public Ingrediente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getCantidad() {
        return cantidad;
    }

    public Ingrediente setCantidad(String cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    @Override
    public String toString() {
        return cantidad +"  "+ nombre;
    }
}
