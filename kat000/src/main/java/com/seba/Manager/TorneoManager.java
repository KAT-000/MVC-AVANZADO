package com.seba.Manager;

import java.util.List;

import com.seba.modelo.JugadorAmateur;
import com.seba.modelo.JugadorPro;
import com.seba.modelo.dao.JugadorAmateurDao;
import com.seba.modelo.dao.JugadorAmateurJsonDao;
import com.seba.modelo.dao.JugadorProDao;
import com.seba.modelo.dao.JugadorProJsonDao;
import com.seba.modelo.excepciones.CupoTorneoAgotadoException;
import com.seba.modelo.excepciones.ParticipanteDuplicadoException;

public class TorneoManager {
    private static final int CUPO_MAXIMO = 16;

    private List<JugadorAmateur> amateurs;
    private List<JugadorPro> pros;

    private JugadorAmateurDao amateurDao;
    private JugadorProDao proDao;

    public TorneoManager() {
        this.amateurDao = new JugadorAmateurJsonDao();
        this.proDao = new JugadorProJsonDao();
        cargarDatos();
    }

    public void agregarJugadorAmateur(JugadorAmateur amateur) throws CupoTorneoAgotadoException, ParticipanteDuplicadoException {validarInscripciones(amateur.getRut()); amateurs.add(amateur); guardarDatos();}

    public void agregarJugadorPro(JugadorPro pro)  throws CupoTorneoAgotadoException, ParticipanteDuplicadoException {validarInscripciones(pro.getRut()); pros.add(pro); guardarDatos();}

    public List<JugadorAmateur> getJugadorAmateur(){return amateurs;}

    public List<JugadorPro> getJugadorPro(){return pros;}

    public void guardarDatos(){amateurDao.guardar(amateurs); proDao.guardar(pros);}

    public void cargarDatos(){this.amateurs = amateurDao.obtenerTodos(); this.pros = proDao.obtenerTodos();}

    private void validarInscripciones(String rutNuevo) throws CupoTorneoAgotadoException, ParticipanteDuplicadoException {
        if ((amateurs.size() + pros.size()) >= CUPO_MAXIMO){
            throw new CupoTorneoAgotadoException("El torneo ya alcanzo su limite de " + CUPO_MAXIMO + "participantes.");
        }
        for (JugadorAmateur a : amateurs){
            if (a.getRut().equalsIgnoreCase(rutNuevo)) {
                throw new ParticipanteDuplicadoException("El rut" + rutNuevo + "ya esta registrado como jugador amateur.");
            }
        }
        for (JugadorPro p : pros) {
            if (p.getRut().equalsIgnoreCase(rutNuevo)) {
                throw new ParticipanteDuplicadoException("El rut" + rutNuevo + "ya esta registrado como jugador pro.");
            }
        }
    }
    
}
