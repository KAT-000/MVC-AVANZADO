package com.estudio.modelo;

public abstract class Propiedad {

    protected int id;
    protected String tipo;
    protected String direccion;
    protected int arriendo;
    protected int metrosCuadrados;

    public Propiedad(int id, String tipo, String direccion, int arriendo, int metrosCuadrados) {
        this.id = id;
        this.tipo = tipo;
        this.direccion = direccion;
        this.arriendo = arriendo;
        this.metrosCuadrados = metrosCuadrados;
    }

    public Propiedad(String tipo, String direccion, int arriendo, int metrosCuadrados) {
        this.tipo = tipo;
        this.direccion = direccion;
        this.arriendo = arriendo;
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getArriendo() {
        return arriendo;
    }

    public void setArriendo(int arriendo) {
        this.arriendo = arriendo;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }
    
    public abstract int CalcularPagoMensual();
    public abstract void ObtenerDetalles();

    

    
}
