package com.seba.modelo;

public class PokemonNormal extends Pokemon {

    private int nivelEvolucion;

    public PokemonNormal(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed, String name,
            String ability, int nivelEvolucion) {
        super(hp, attack, defense, specialAttack, specialDefense, speed, name, ability);
        this.nivelEvolucion = nivelEvolucion;
    }

    public int getNivelEvolucion() {
        return nivelEvolucion;
    }

    public void setNivelEvolucion(int nivelEvolucion) {
        this.nivelEvolucion = nivelEvolucion;
    }

    @Override 
    
    public double calcularIndicePoder(){
        return hp + attack + defense + specialAttack + specialDefense + speed;
    }

    @Override 
    public String getCategoria(){
        return "Normal";
    }

    
}
