package com.seba.modelo.dao;

import java.util.List;

import com.seba.modelo.PokemonNormal;

public interface PokemonNormalDao {

    public List<PokemonNormal> obtenerTodos();
    void guardar(List<PokemonNormal> pokemon);
    
}
