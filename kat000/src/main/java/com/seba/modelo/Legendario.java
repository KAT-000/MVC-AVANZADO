package com.seba.modelo;

public class Legendario extends Pokemon{

    private boolean esMitico;
    private String regionExclusiva;

    public Legendario(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed, String name,
            String ability, boolean esMitico, String regionExclusiva) {
        super(hp, attack, defense, specialAttack, specialDefense, speed, name, ability);
        this.esMitico = esMitico;
        this.regionExclusiva = regionExclusiva;
    }


    public boolean isEsMitico() {
        return esMitico;
    }
    public void setEsMitico(boolean esMitico) {
        this.esMitico = esMitico;
    }
    public String getRegionExclusiva() {
        return regionExclusiva;
    }
    public void setRegionExclusiva(String regionExclusiva) {
        this.regionExclusiva = regionExclusiva;
    }

    @Override 
    
    public double calcularIndicePoder(){
        double suma = hp + attack + defense + specialAttack + specialDefense + speed;
        return esMitico ? suma * 1.30 : suma * 1.25;
    }

    @Override 
    public String getCategoria(){
        return "Legendario";
    }

    
    
}
