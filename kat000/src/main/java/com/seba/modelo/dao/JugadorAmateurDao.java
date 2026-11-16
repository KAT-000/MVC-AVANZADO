package com.seba.modelo.dao;

import java.util.List;

import com.seba.modelo.JugadorAmateur;

public interface JugadorAmateurDao {
    public List<JugadorAmateur> obtenerTodos();
    void guardar(List<JugadorAmateur> amateurs);
}
