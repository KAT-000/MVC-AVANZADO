package com.seba.modelo;

import com.seba.modelo.excepciones.RutInvalidoException;

public abstract class Participante {
    protected String rut;
    protected String nickname;
    protected String nombreCompleto;
    protected String correo;
    public Participante(String rut, String nickname, String nombreCompleto, String correo) throws RutInvalidoException {
        this.setRut(rut);
        this.nickname = nickname;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) throws RutInvalidoException {
        if (!validarRut(rut)){ throw new RutInvalidoException("Rut ingresado invalido.");}
        this.rut = rut;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public abstract double calcularCuotaInscripcion();
    public abstract String obtenerBadgeCategoria();

    private boolean validarRut(String rut){

        if (rut == null || rut.isEmpty()){return false;}
        rut = rut.replace(".", "").replace("-", "").toUpperCase();

        if (rut.length() < 8 || rut.length() > 9){return false;}


        char dvIngresado = rut.charAt(rut.length() - 1);
        String cuerpoTexto = rut.substring(0, rut.length() - 1);

        try {
            int cuerpo = Integer.parseInt(cuerpoTexto);
            int suma = 0;
            int multiplicador = 2;

            while (cuerpo > 0){
                suma += (cuerpo % 10) * multiplicador;
                cuerpo /= 10;
                multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
            }

            int resto = 11 - (suma % 11);
            char dvCalculo = (resto == 11) ? '0' : (resto == 10) ? 'K' : (char) (resto + '0');
            return dvIngresado == dvCalculo;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
}
