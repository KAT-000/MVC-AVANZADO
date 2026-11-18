package com.trabajoprofe;

public class Juego {

    private int id;
    private String nombre;
    private int precio;
    private String consola;


    public Juego(int id, String nombre, int precio, String consola) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.consola = consola;
    }

     public Juego(String nombre, int precio, String consola) {
        this.nombre = nombre;
        this.precio = precio;
        this.consola = consola;
    }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     public int getPrecio() {
         return precio;
     }

     public void setPrecio(int precio) {
         this.precio = precio;
     }

     public String getConsola() {
         return consola;
     }

     public void setConsola(String consola) {
         this.consola = consola;
     }

    


    
    
}
