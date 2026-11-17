package com.seba.modelo.dao;

import java.util.List;

import com.seba.modelo.Legendario;

public interface LegendarioDao {

    public List<Legendario> obtenerTodos();
    void guardar(List<Legendario> legendario);
    
}
