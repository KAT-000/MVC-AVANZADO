package com.estudio.dao;


import java.util.List;

import com.estudio.modelo.Propiedad;

public interface PropiedadDao {

    public List<Propiedad> obtenerTodos();
    void guardar(Propiedad propiedad);
    void actualizar(Propiedad propiedad);
    void eliminar(int id);
    
}
