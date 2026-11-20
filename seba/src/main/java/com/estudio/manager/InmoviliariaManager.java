package com.estudio.manager;

import java.util.ArrayList;
import java.util.List;

import com.estudio.dao.PropiedadDBDao;
import com.estudio.dao.PropiedadDao;
import com.estudio.modelo.Casa;
import com.estudio.modelo.Departamento;
import com.estudio.modelo.Propiedad;
import com.estudio.modelo.excepciones.CasaDuplicadaException;
import com.estudio.modelo.excepciones.CasaInvalidaException;
import com.estudio.modelo.excepciones.CasaNoEncontradaException;
import com.estudio.modelo.excepciones.DepartamentoDuplicadoException;
import com.estudio.modelo.excepciones.DepartamentoInvalidoException;
import com.estudio.modelo.excepciones.DepartamentoNoEncontradoException;

public class InmoviliariaManager {

    private PropiedadDao propiedadDao;

    public InmoviliariaManager() {

        this.propiedadDao = new PropiedadDBDao();
    }

    public void agregarPropiedad(Propiedad prop) throws CasaInvalidaException, CasaDuplicadaException,
            DepartamentoInvalidoException, DepartamentoDuplicadoException {

        if (prop == null) {
            throw new CasaInvalidaException("La propidedad no debe quedar en blanco.");
        }

        if (prop instanceof Casa) {
            Casa casa = (Casa) prop;
            if (casa.getDireccion() == null || casa.getDireccion().trim().isEmpty()) {
                throw new CasaInvalidaException("La direccion de la casa no debe quedar en blanco");
            }
            if (casa.getArriendo() <= 0) {
                throw new CasaInvalidaException("El arriendo no puede ser 0 o menor");
            }
            if (casa.getMetrosCuadrados() <= 0) {
                throw new CasaInvalidaException("Los metros cuadrados no pueden ser 0 o menor");
            }
            if (casa.getCantidadDePisos() <= 0) {
                throw new CasaInvalidaException("La cantidad de pisos no pueden ser 0 o menos");
            }

            for (Propiedad p : propiedadDao.obtenerTodos()) {
                if (p.getDireccion().equalsIgnoreCase(casa.getDireccion())) {
                    throw new CasaDuplicadaException(
                            "No puedes repetir la misma casa. \nSi quieres poner la misma direccion, asegurate de identificar las casas por numero.");
                }
            }
            propiedadDao.guardar(casa);
        }

        else if (prop instanceof Departamento) {
            Departamento departamento = (Departamento) prop;
            if (departamento.getDireccion() == null || departamento.getDireccion().trim().isEmpty()) {
                throw new DepartamentoInvalidoException("La direccion del departamento no debe quedar en blanco");
            }
            if (departamento.getArriendo() <= 0) {
                throw new DepartamentoInvalidoException("El arriendo no puede ser 0 o menor");
            }
            if (departamento.getMetrosCuadrados() <= 0) {
                throw new DepartamentoInvalidoException("Los metros cuadrados no pueden ser 0 o menor");
            }
            if (departamento.getNumeroDePiso() <= 0) {
                throw new DepartamentoInvalidoException("El de piso no puede ser 0 o menos");
            }
            if (departamento.getGastosComunes() <= 0) {
                throw new DepartamentoInvalidoException("Ojala los gastos comunes fueran de 0, pero no.");
            }

            for (Propiedad p : propiedadDao.obtenerTodos()) {
                if (p.getDireccion().equalsIgnoreCase(departamento.getDireccion())) {
                    throw new DepartamentoDuplicadoException(
                            "No puedes repetir el departamento. \nSi quieres poner la misma direccion, asegurate de identificarlos por numero.");
                }
            }

            propiedadDao.guardar(departamento);

        }
    }

    public void eliminarPropiedad(int id) throws CasaNoEncontradaException {
        boolean existe = false;

        for (Propiedad p : propiedadDao.obtenerTodos()) {
            if (p.getId() == id) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            throw new CasaNoEncontradaException("Propiedad no encontrada");
        }
        propiedadDao.eliminar(id);

    }

    public List<Propiedad> ListarTodas() {
        return propiedadDao.obtenerTodos();
    }

    public List<Casa> listarCasas() {
        List<Casa> listaCasas = new ArrayList<>();
        for (Propiedad p : propiedadDao.obtenerTodos()) {
            if (p instanceof Casa) {
                listaCasas.add((Casa) p);
            }
        }
        return listaCasas;
    }

    public List<Departamento> listarDepartamentos() {
        List<Departamento> listaDepartamentos = new ArrayList<>();
        for (Propiedad p : propiedadDao.obtenerTodos()) {
            if (p instanceof Departamento) {
                listaDepartamentos.add((Departamento) p);
            }
        }
        return listaDepartamentos;
    }

    public void actualizarPropiedad(Propiedad prop) throws CasaInvalidaException,
            CasaNoEncontradaException, CasaDuplicadaException, DepartamentoInvalidoException,
            DepartamentoNoEncontradoException, DepartamentoDuplicadoException {

        if (prop == null) {
            throw new CasaInvalidaException("La propiedad no puede estar vacia");
        }
        boolean existe = false;
        for (Propiedad p : propiedadDao.obtenerTodos()) {
            if (p.getId() == prop.getId()) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            if (prop instanceof Casa) {
                throw new CasaNoEncontradaException("No se encontro la casa con el id: " + prop.getId());
            } else {
                throw new DepartamentoNoEncontradoException(
                        "No se encontro el departamento con el id: " + prop.getId());
            }
        }

        if (prop instanceof Casa) {
            Casa casa = (Casa) prop;

            if (casa.getDireccion() == null || casa.getDireccion().trim().isEmpty()) {
                throw new CasaNoEncontradaException("Direccion no encontrada");
            }
            if (casa.getArriendo() <= 0 || casa.getMetrosCuadrados() <= 0 || casa.getCantidadDePisos() <= 0) {
                throw new CasaInvalidaException("Los valores numericos siempre deben ser mayores a 0");
            }

            for (Propiedad p : propiedadDao.obtenerTodos()) {
                if (p.getId() != casa.getId() && p.getDireccion().equalsIgnoreCase(casa.getDireccion().trim())) {

                    throw new CasaDuplicadaException(
                            "Otra propiedad ya tiene esa direccion, si quieres actualizar esta propiedad deberas especificar su numero unico");
                }
            }
            propiedadDao.actualizar(casa);

        } else if (prop instanceof Departamento) {
            Departamento departamento = (Departamento) prop;
            if (departamento.getDireccion() == null || departamento.getDireccion().trim().isEmpty()) {
                throw new DepartamentoInvalidoException("La direccion del departamento no debe quedar vacia");
            }
            if (departamento.getArriendo() <= 0 || departamento.getMetrosCuadrados() <= 0
                    || departamento.getNumeroDePiso() <= 0) {
                throw new DepartamentoInvalidoException("Los valores numericos siempre deben ser mayores a 0");
            }

            for (Propiedad p : propiedadDao.obtenerTodos()) {
                if (p.getId() != departamento.getId()
                        && p.getDireccion().equalsIgnoreCase(departamento.getDireccion().trim())) {

                    throw new DepartamentoDuplicadoException(
                            "Otra propiedad ya tiene esa direccion, si quieres actualizar esta propiedad deberas especificar su numero unico");
                }
            }
            propiedadDao.actualizar(departamento);

        }

    }

}
