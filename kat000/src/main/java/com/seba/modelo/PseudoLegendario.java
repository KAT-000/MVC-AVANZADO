package com.seba.modelo;

public class PseudoLegendario extends Pokemon {

    private String etapaEvolutiva;

    public PseudoLegendario(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed,
            String name, String ability, String etapaEvolutiva) {
        super(hp, attack, defense, specialAttack, specialDefense, speed, name, ability);
        this.etapaEvolutiva = etapaEvolutiva;
    }

    public String getEtapaEvolutiva() {
        return etapaEvolutiva;
    }

    public void setEtapaEvolutiva(String etapaEvolutiva) {
        this.etapaEvolutiva = etapaEvolutiva;
    }

    @Override 
    
    public double calcularIndicePoder(){
        return (hp + attack + defense + specialAttack + specialDefense + speed) * 1.10;
    }

    @Override 
    public String getCategoria(){
        return "PseudoLegendario";
    }
    
}
