package com.estudio.modelo;

public class Departamento extends Propiedad {

    private int numeroDePiso;
    private int gastosComunes;


    public Departamento(int id, String tipo, String direccion, int arriendo, int metrosCuadrados, int numeroDePiso,
            int gastosComunes) {
        super(id, tipo, direccion, arriendo, metrosCuadrados);
        this.numeroDePiso = numeroDePiso;
        this.gastosComunes = gastosComunes;
    }
    public Departamento(String tipo, String direccion, int arriendo, int metrosCuadrados, int numeroDePiso,
            int gastosComunes) {
        super(tipo, direccion, arriendo, metrosCuadrados);
        this.numeroDePiso = numeroDePiso;
        this.gastosComunes = gastosComunes;
    }
    public int getNumeroDePiso() {
        return numeroDePiso;
    }
    public void setNumeroDePiso(int numeroDePiso) {
        this.numeroDePiso = numeroDePiso;
    }
    public int getGastosComunes() {
        return gastosComunes;
    }
    public void setGastosComunes(int gastosComunes) {
        this.gastosComunes = gastosComunes;
    }

    @Override 
    public int CalcularPagoMensual(){
        int pagoTotal = arriendo + gastosComunes;
        System.out.println("Pago mensual del departamento: " + pagoTotal);
        return pagoTotal;
    }

    @Override 
    public void ObtenerDetalles(){

        System.out.println("ID: " + id + " Tipo: " + tipo + " Direccion: " + " Numero de pisos: " + numeroDePiso + " Gastos comunes: " + gastosComunes + " Metros cuadrados: " + metrosCuadrados + " Arriendo: " + arriendo);

    }
     
    
    
}
