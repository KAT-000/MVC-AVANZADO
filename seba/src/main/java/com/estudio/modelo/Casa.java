package com.estudio.modelo;

public class Casa extends Propiedad {

    private int cantidadDePisos;
    private boolean tienePatio;

    public Casa(int id, String tipo, String direccion, int arriendo, int metrosCuadrados, int cantidadDePisos,
            boolean tienePatio) {
        super(id, tipo, direccion, arriendo, metrosCuadrados);
        this.cantidadDePisos = cantidadDePisos;
        this.tienePatio = tienePatio;
    }
    public Casa(String tipo, String direccion, int arriendo, int metrosCuadrados, int cantidadDePisos,
            boolean tienePatio) {
        super(tipo, direccion, arriendo, metrosCuadrados);
        this.cantidadDePisos = cantidadDePisos;
        this.tienePatio = tienePatio;
    }
    public int getCantidadDePisos() {
        return cantidadDePisos;
    }
    public void setCantidadDePisos(int cantidadDePisos) {
        this.cantidadDePisos = cantidadDePisos;
    }
    public boolean isTienePatio() {
        return tienePatio;
    }
    public void setTienePatio(boolean tienePatio) {
        this.tienePatio = tienePatio;
    }

    @Override 
    public int CalcularPagoMensual(){
        int pagoTotal = tienePatio ? (arriendo + 50000) : arriendo;
        System.out.println("Pago mensual de la casa: " + pagoTotal);
        return pagoTotal;
    }

    @Override 
    public void ObtenerDetalles(){

        System.out.println("ID: " + id + " Tipo: " + tipo + " Direccion: " + " Cantidad de pisos: " + cantidadDePisos + " ¿Tiene patio?:" + tienePatio + " Metros cuadrados: " + metrosCuadrados + " Arriendo: " + arriendo);


    }

    
}
