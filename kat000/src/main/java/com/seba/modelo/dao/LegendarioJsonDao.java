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
import com.seba.modelo.Legendario;

public class LegendarioJsonDao implements LegendarioDao {

    private final String archivo = "PokemonLegendario.json";
    private final Gson gson = new Gson();

    @Override 
    public List<Legendario> obtenerTodos(){

        File file = new File(archivo);
        if (!file.exists()){return new ArrayList<>();}
        try (FileReader reader = new FileReader(file);){
            Type tipo = new TypeToken<List<Legendario>>() {}.getType();
            List<Legendario> lista = gson.fromJson(reader, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {System.out.println("Error al leer 'PokemonLegendario.json' " + e.getMessage());
            return new ArrayList<>();
        }

    }

    @Override 
    public void guardar(List<Legendario> legendario){
        try(FileWriter writer = new FileWriter(archivo)){
            gson.toJson(legendario, writer);
        } catch (IOException e ) {System.out.println("Error al guardar 'PokemonLegendario.json' " + e.getMessage());}
    }
    
}
