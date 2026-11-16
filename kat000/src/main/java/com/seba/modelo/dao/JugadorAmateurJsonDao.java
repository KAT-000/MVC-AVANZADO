package com.seba.modelo.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.seba.modelo.JugadorAmateur;

public class JugadorAmateurJsonDao implements JugadorAmateurDao {

    private final String archivo = "JugadoresAmateur.json";
    private final Gson gson = new Gson();

    @Override 
    public List<JugadorAmateur> obtenerTodos(){

        File file = new File(archivo);
        if ( !file.exists() ){ return new ArrayList<>(); }

        try ( FileReader reader = new FileReader(file) )
        { Type tipo = new TypeToken<ArrayList<JugadorAmateur>>() {}.getType(); 
        List<JugadorAmateur> lista = gson.fromJson(reader, tipo);
        return lista != null ? lista : new ArrayList<>(); }
        catch (IOException e) { System.out.println("Error al leer 'JugadorAmateur.json': " + e.getMessage());
        return new ArrayList<>(); }
    }

    @Override 
    public void guardar(List<JugadorAmateur> amateurs){
        try (FileWriter writer = new FileWriter(archivo)) 
        {gson.toJson(amateurs, writer);} 
        catch (IOException e) {System.out.println("Error al guardar 'JugadorAmateur.json': " + e.getMessage());}
    }
    
}
