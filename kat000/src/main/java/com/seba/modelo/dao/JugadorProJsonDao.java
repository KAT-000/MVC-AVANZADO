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
import com.seba.modelo.JugadorPro;

public class JugadorProJsonDao implements JugadorProDao{

    private final String archivo = "JugadoresPro.json";
    private final Gson gson = new Gson();

    @Override 
    public List<JugadorPro> obtenerTodos(){

        File file = new File(archivo);
        if ( !file.exists() ){ return new ArrayList<>(); }

        try ( FileReader reader = new FileReader(file) )
        { Type tipo = new TypeToken<ArrayList<JugadorPro>>() {}.getType(); 
        List<JugadorPro> lista = gson.fromJson(reader, tipo);
        return lista != null ? lista : new ArrayList<>(); }
        catch (IOException e) { System.out.println("Error al leer 'JugadorPro.json': " + e.getMessage());
        return new ArrayList<>(); }
    }

    @Override 
    public void guardar(List<JugadorPro> pro){
        try (FileWriter writer = new FileWriter(archivo)) 
        {gson.toJson(pro, writer);} 
        catch (IOException e) {System.out.println("Error al guardar 'JugadorPro.json': " + e.getMessage());}
    }
    
}
