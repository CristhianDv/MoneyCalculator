package modelo;

public class Currency {
    private String nombre;      // EURO
    private String codigo;        // €
    private String simbolo;     // EUR

    public Currency(String nombre, String codigo, String simbolo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    @Override
    public String toString(){
        return "" + this.nombre + " " + this.codigo + " " + this.simbolo;
    }
    
    
}
