package com.seba.modelo;

import com.seba.modelo.excepciones.RutInvalidoException;

public class JugadorAmateur extends Participante {

    private String juegoPrincipal;
    private String rangoActual;
    private int horasEntrenamiento;
    public JugadorAmateur(String rut, String nikname, String nombreCompleto, String correo, String juegoPrincipal,
            String rangoActual, int horasEntrenamiento) throws RutInvalidoException {
        super(rut, nikname, nombreCompleto, correo);
        this.juegoPrincipal = juegoPrincipal;
        this.rangoActual = rangoActual;
        this.horasEntrenamiento = horasEntrenamiento;
    }
    public String getJuegoPrincipal() {
        return juegoPrincipal;
    }
    public void setJuegoPrincipal(String juegoPrincipal) {
        this.juegoPrincipal = juegoPrincipal;
    }
    public String getRangoActual() {
        return rangoActual;
    }
    public void setRangoActual(String rangoActual) {
        this.rangoActual = rangoActual;
    }
    public int getHorasEntrenamiento() {
        return horasEntrenamiento;
    }
    public void setHorasEntrenamiento(int horasEntrenamiento) {
        this.horasEntrenamiento = horasEntrenamiento;
    }
    
    @Override
    public double calcularCuotaInscripcion() {
        double cuotaBase = 10000;
        if ( this.horasEntrenamiento > 20){
            return cuotaBase * 0.8;
        }
        return cuotaBase;
    }

    @Override 
    public String obtenerBadgeCategoria(){
        return "Amateur - Rango: " + this.rangoActual;
    }
    
}
