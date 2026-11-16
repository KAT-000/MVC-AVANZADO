package com.seba.modelo.dao;

import java.util.List;

import com.seba.modelo.JugadorPro;

public interface JugadorProDao {

    public List<JugadorPro> obtenerTodos();
    void guardar(List<JugadorPro> pro);
    
}
