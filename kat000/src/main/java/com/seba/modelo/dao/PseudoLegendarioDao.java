package com.seba.modelo.dao;

import java.util.List;

import com.seba.modelo.PseudoLegendario;

public interface PseudoLegendarioDao {

    public List<PseudoLegendario> obtenerTodos();
    void guardar(List<PseudoLegendario> pseudo);
    
}
