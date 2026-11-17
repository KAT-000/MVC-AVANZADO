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
import com.seba.modelo.PokemonNormal;

public class PokemonNormalJsonDao implements PokemonNormalDao {

    private final String archivo = "PokemonNormal.Json";
    private final Gson gson = new Gson();

    @Override 
    public List<PokemonNormal> obtenerTodos(){

        File file = new File(archivo);
        if (!file.exists()){ return new ArrayList<>();}

        try (FileReader reader = new FileReader(file)){
            Type tipo = new TypeToken<List<PokemonNormal>>() {}.getType();
            List<PokemonNormal> lista = gson.fromJson(reader, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {System.out.println("Error al leer 'PokemonNormal.json' " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override 
    public void guardar(List<PokemonNormal> pokemon){
        try (FileWriter writer = new FileWriter(archivo)){
            gson.toJson(pokemon, writer);
        } catch (IOException e) {System.out.println("Error al guardar 'PokemonNormal.json' " + e.getMessage());
        }

    }
    
}
