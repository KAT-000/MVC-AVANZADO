package com.seba.controlador;

import com.seba.Manager.TorneoManager;
import com.seba.modelo.JugadorAmateur;
import com.seba.modelo.JugadorPro;
import com.seba.modelo.Participante;
import com.seba.modelo.excepciones.CupoTorneoAgotadoException;
import com.seba.modelo.excepciones.ParticipanteDuplicadoException;
import com.seba.modelo.excepciones.RutInvalidoException;
import com.seba.vista.TorneoVista;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class TorneoController {

    private TorneoManager modelo;
    private TorneoVista vista;

    public TorneoController(TorneoManager modelo, TorneoVista vista) {
        this.modelo = new TorneoManager();
        this.vista = vista;

        this.vista.getBtnRegistrar().setOnAction(e -> registrarParticipante());
        this.vista.getCmbTipoJugador().setOnAction(e -> bloquearCamposSegunTipo());

        actualizarTabla();
        bloquearCamposSegunTipo();
    }

    private void registrarParticipante(){
    try {
        String rut = vista.getTxtRut().getText().trim();
        String nickname = vista.getTxtNickname().getText().trim();
        String nombreCompleto = vista.getTxtNombres().getText().trim();
                                vista.getTxtApellidoPaterno().getText().trim();
                                vista.getTxtApellidoMaterno().getText().trim();
        String correo = vista.getTxtCorreo().getText().trim();
        String tipo = vista.getCmbTipoJugador().getValue();

        if ( tipo.equals("Amateur") ){
            String juego = vista.getTxtJuegoPrincipal().getText().trim();
            String rango = vista.getTxtRangoActual().getText().trim();
            int horas = Integer.parseInt(vista.getTxtHorasEntrenamiento().getText().trim());
            JugadorAmateur amateur = new JugadorAmateur(rut, nickname, nombreCompleto, correo, juego, rango, horas);
            modelo.agregarJugadorAmateur(amateur);
        } else {
            String equipo = vista.getTxtEquipoOficial().getText().trim();
            Double sueldo = Double.parseDouble(vista.getTxtSueldoBase().getText().trim());
            int torneos = Integer.parseInt(vista.getTxtTorneosGanados().getText().trim());
            JugadorPro pro = new JugadorPro(rut, nickname, nombreCompleto, correo, equipo, sueldo, torneos);
            modelo.agregarJugadorPro(pro);
        }

        mostrarAlerta(Alert.AlertType.INFORMATION, "Exito", "Participante registrado correctamente.");
        limpiarCampos();
        actualizarTabla();

    } catch (NumberFormatException e) {mostrarAlerta(Alert.AlertType.ERROR, "Error de numero", "Ingresa solo numeros validos en horas, sueldo o torneos");}
        catch (RutInvalidoException | CupoTorneoAgotadoException | ParticipanteDuplicadoException e) {mostrarAlerta(Alert.AlertType.ERROR, "Error de validacion", e.getMessage());}
    }

    private void actualizarTabla(){
        vista.getTablaParticipantes().getItems().clear();
        vista.getTablaParticipantes().getItems().addAll(modelo.getJugadorAmateur());
        vista.getTablaParticipantes().getItems().addAll(modelo.getJugadorPro());
    }

    private void bloquearCamposSegunTipo(){
        boolean esAmateur = vista.getCmbTipoJugador().getValue().equals("Amateur");

        vista.getTxtJuegoPrincipal().setDisable(!esAmateur);
        vista.getTxtRangoActual().setDisable(!esAmateur);
        vista.getTxtHorasEntrenamiento().setDisable(!esAmateur);

        vista.getTxtEquipoOficial().setDisable(esAmateur);
        vista.getTxtSueldoBase().setDisable(esAmateur);
        vista.getTxtTorneosGanados().setDisable(esAmateur);
    }

    private void limpiarCampos() {

        vista.getTxtRut().clear();
        vista.getTxtNickname().clear();
        vista.getTxtNombres().clear();
        vista.getTxtApellidoPaterno().clear();
        vista.getTxtApellidoMaterno().clear();
        vista.getTxtCorreo().clear();
        vista.getTxtJuegoPrincipal().clear();
        vista.getTxtRangoActual().clear();
        vista.getTxtHorasEntrenamiento().clear();
        vista.getTxtEquipoOficial().clear();
        vista.getTxtSueldoBase().clear();
        vista.getTxtTorneosGanados().clear();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){

        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }
}
