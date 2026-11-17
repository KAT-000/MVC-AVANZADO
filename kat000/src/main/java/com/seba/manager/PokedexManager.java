package com.seba.manager;

import java.util.ArrayList;
import java.util.List;

import com.seba.modelo.Legendario;
import com.seba.modelo.Pokemon;
import com.seba.modelo.PokemonNormal;
import com.seba.modelo.PseudoLegendario;
import com.seba.modelo.dao.LegendarioDao;
import com.seba.modelo.dao.LegendarioJsonDao;
import com.seba.modelo.dao.PokemonNormalDao;
import com.seba.modelo.dao.PokemonNormalJsonDao;
import com.seba.modelo.dao.PseudoLegendarioDao;
import com.seba.modelo.dao.PseudoLegendarioJsonDao;
import com.seba.modelo.excepciones.PokemonDuplicadoException;
import com.seba.modelo.excepciones.PokemonInvalidoException;
import com.seba.modelo.excepciones.PokemonNoEncontradoException;

public class PokedexManager {

    private PokemonNormalDao normalDao = new PokemonNormalJsonDao();
    private PseudoLegendarioDao pseudoDao = new PseudoLegendarioJsonDao();
    private LegendarioDao legendarioDao = new LegendarioJsonDao();

    private List<PokemonNormal> normales;
    private List<PseudoLegendario> pseudos;
    private List<Legendario> legendarios;

    public PokedexManager(){
        this.normales = normalDao.obtenerTodos();
        this.pseudos = pseudoDao.obtenerTodos();
        this.legendarios = legendarioDao.obtenerTodos();
    }

    private void validarDatos(String nombre, String habilidad, int hp, int ataque, int defensa, int atEsp, int defEsp, int velocidad) 
    throws PokemonInvalidoException, PokemonDuplicadoException {
        if (nombre == null || nombre.trim().isEmpty() || habilidad == null || habilidad.trim().isEmpty()){
            throw new PokemonInvalidoException("Error, nombre y habilidad no pueden quedar en blanco.");
        }

        if (hp <= 0 || ataque <= 0 || defensa <= 0 || atEsp <= 0 || defEsp <= 0 || velocidad <= 0 ||
         hp > 255 || ataque > 255 || defensa > 255 || atEsp > 255 || defEsp > 255 || velocidad > 255) {
            throw new PokemonInvalidoException("Las stats deben estar en un rango de entre '0' y '255'");
         }

         for (Pokemon p : obtenerTodos()) { if (p.getName().equalsIgnoreCase(nombre.trim())){throw new PokemonDuplicadoException("El pokemon " + nombre + " ya esta registrado en la Pokedex");}}
    }

    public List<Pokemon> obtenerTodos() {
        List<Pokemon> todos = new ArrayList<>();
        todos.addAll(normales);
        todos.addAll(pseudos);
        todos.addAll(legendarios);
        return todos;
    }

    public void agregarNormal(String nombre, String habilidad, int hp, int ataque, int defensa, int atEsp, int defEsp, int velocidad, int nivleEvolucion)
    throws PokemonInvalidoException, PokemonDuplicadoException {
        validarDatos(nombre, habilidad, hp, ataque, defensa, atEsp, defEsp, velocidad);
        if (nivleEvolucion < 0){
            throw new PokemonInvalidoException("El nivel de evolucion no puede ser negativo");
        }

        PokemonNormal nuevo = new PokemonNormal(hp, ataque, defensa, atEsp, defEsp, velocidad, nombre, habilidad, nivleEvolucion);
        normales.add(nuevo);
        normalDao.guardar(normales);
    }

    public void agregarPseudo(String nombre, String habilidad, int hp, int ataque, int defensa, int atEsp, int defEsp, int velocidad, String etapaEvolutiva)
    throws PokemonInvalidoException, PokemonDuplicadoException {
        validarDatos(nombre, habilidad, hp, ataque, defensa, atEsp, defEsp, velocidad);
        if (etapaEvolutiva == null || etapaEvolutiva.trim().isEmpty()){
            throw new PokemonInvalidoException("Debes indicar la etapa evolutiva");
        }

        PseudoLegendario nuevo = new PseudoLegendario(hp, ataque, defensa, atEsp, defEsp, velocidad, nombre, habilidad, etapaEvolutiva);
        pseudos.add(nuevo);
        pseudoDao.guardar(pseudos);
    }

    public void agregarLegendario(String nombre, String habilidad, int hp, int ataque, int defensa, int atEsp, int defEsp, int velocidad, String regionExclusiva, boolean esMitico)
    throws PokemonInvalidoException, PokemonDuplicadoException {
        validarDatos(nombre, habilidad, hp, ataque, defensa, atEsp, defEsp, velocidad);
        if (regionExclusiva == null || regionExclusiva.trim().isEmpty()){
            throw new PokemonInvalidoException("Debes indicar la region exclusiva");
        }

        Legendario nuevo = new Legendario(hp, ataque, defensa, atEsp, defEsp, velocidad, nombre, habilidad, esMitico, regionExclusiva);
        legendarios.add(nuevo);
        legendarioDao.guardar(legendarios);
    }

    public List<Pokemon> buscarYFiltrar(String texto, String categoria){
        List<Pokemon> filtrados = new ArrayList<>();
        String busqueda = (texto == null) ? "" : texto.toLowerCase().trim();

        for (Pokemon p : obtenerTodos()) {
            boolean coincideNombre = p.getName().toLowerCase().contains(busqueda);
            boolean coincidenCategoria = (categoria == null || "Todos".equalsIgnoreCase(categoria)) || p.getCategoria().equalsIgnoreCase(categoria);
        
            if (coincideNombre && coincidenCategoria) {
                filtrados.add(p);
            }
        } return filtrados;
    }   

    public void eliminarPokemon(Pokemon p) throws PokemonNoEncontradoException {
        if (p == null){
            throw new PokemonNoEncontradoException("Debes seleccionar un pokemon de la tabla para eliminarlo");
        }

        if (p instanceof PokemonNormal) {
            normales.remove(p);
            normalDao.guardar(normales);
        }

        if (p instanceof PseudoLegendario) {
            pseudos.remove(p);
            pseudoDao.guardar(pseudos);
        }

        if (p instanceof Legendario) {
            legendarios.remove(p);
            legendarioDao.guardar(legendarios);
        }
    }
}
