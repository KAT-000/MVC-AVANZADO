package com.seba.modelo;

import com.seba.modelo.excepciones.RutInvalidoException;

public class JugadorPro extends Participante {

    private String equipoOficial;
    private Double sueldoBase;
    private int torneosGanados;
    public JugadorPro(String rut, String nikname, String nombreCompleto, String correo, String equipoOficial,
            Double sueldo, int torneosGanados) throws RutInvalidoException {
        super(rut, nikname, nombreCompleto, correo);
        this.equipoOficial = equipoOficial;
        this.sueldoBase = sueldo;
        this.torneosGanados = torneosGanados;
    }
    public String getEquipoOficial() {
        return equipoOficial;
    }
    public void setEquipoOficial(String equipoOficial) {
        this.equipoOficial = equipoOficial;
    }
    public Double getSueldoBase() {
        return sueldoBase;
    }
    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = (double) sueldoBase;
    }
    public int getTorneosGanados() {
        return torneosGanados;
    }
    public void setTorneosGanados(int torneosGanados) {
        this.torneosGanados = torneosGanados;
    }
    
    @Override
    public double calcularCuotaInscripcion() {
        double cuotaBase = 10000;
        if ( this.torneosGanados > 0){
            return cuotaBase * 0.5;
        }
        return cuotaBase;
    }

    @Override 
    public String obtenerBadgeCategoria(){
        return "PRO - Equipo: " + this.equipoOficial;
    }
}
