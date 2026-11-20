package com.estudio.controlador;

import com.estudio.manager.InmoviliariaManager;
import com.estudio.modelo.Casa;
import com.estudio.modelo.Departamento;
import com.estudio.modelo.Propiedad;
import com.estudio.vista.InmoviliariaVista;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InmoviliariaControlador {

    private InmoviliariaVista vista;
    private InmoviliariaManager manager;

    public InmoviliariaControlador(InmoviliariaVista vista){
        this.vista = vista;
        this.manager = new InmoviliariaManager();

        vista.getBtnAgregar().setOnAction(e -> agregar());
        vista.getBtnEliminar().setOnAction(e -> eliminar());
        vista.getBtnActualizar().setOnAction(e -> actualizar());
        vista.getBtnLimpiar().setOnAction(e -> limpiar());
        refrescarTablas();
    }

    private void agregar(){
        try {
            Propiedad prop = leerFormulario(0);
            manager.agregarPropiedad(prop);
            refrescarTablas();
            limpiar();
            alertas(AlertType.INFORMATION, "Propiedad agregada");
        } catch (NumberFormatException ex) {
            alertas(AlertType.ERROR, "Ingresa solo numeros validos en arriendo");
        } catch (Exception ex) {
            alertas(AlertType.WARNING, ex.getMessage());
        }
    }
    private void eliminar(){
        Propiedad seleccionada = vista.getTvPropiedades().getSelectionModel().getSelectedItem();
        if (seleccionada == null){
            alertas(AlertType.WARNING, "Selecciona una propiedad de la lista");
            return;
        }
        try{
            manager.eliminarPropiedad(seleccionada.getId());
            refrescarTablas();
            limpiar();
            alertas(AlertType.INFORMATION, "Propiedad eliminada");
        } catch (Exception ex) {
            alertas(AlertType.WARNING, ex.getMessage());
        }
    }
    private void actualizar(){
        Propiedad seleccionada = vista.getTvPropiedades().getSelectionModel().getSelectedItem();
        if (seleccionada == null){
            alertas(AlertType.WARNING, "Selecciona una propiedad de la lista");
            return;
        }
        try {
            Propiedad prop = leerFormulario(seleccionada.getId());
            manager.actualizarPropiedad(prop);
            refrescarTablas();
            limpiar();
            alertas(AlertType.INFORMATION, "Lista actualizada");
        } catch (NumberFormatException ex) {
            alertas(AlertType.ERROR, "Revisa que los campos numericos tengan algun numero valido: " + ex.getMessage());
        } catch (Exception ex) {
            alertas(AlertType.WARNING, ex.getMessage());
        }
    }
    private void limpiar(){
        vista.getTxtDireccion().clear();
        vista.getTxtArriendo().clear();
        vista.getTxtMetros2().clear();
        vista.getTxtCantidadPisos().clear();
        vista.getTxtTienePatio().clear();
        vista.getTxtNumeroDePiso().clear();
        vista.getTxtGastosComunes().clear();
    }
    private Propiedad leerFormulario(int id){
        String tipo = vista.getCmbTipo().getValue();
        String direccion = vista.getTxtDireccion().getText();
        int arriendo = Integer.parseInt(vista.getTxtArriendo().getText());
        int metros = Integer.parseInt(vista.getTxtMetros2().getText());

        if ("CASA".equalsIgnoreCase(tipo)){
            int pisos = Integer.parseInt(vista.getTxtCantidadPisos().getText());
            boolean patio = vista.getTxtTienePatio().getText().trim().equalsIgnoreCase("SI");
            return new Casa(id, tipo, direccion, arriendo, metros, pisos, patio);
        }
        else {
            int numPiso = Integer.parseInt(vista.getTxtNumeroDePiso().getText());
            int gastos = Integer.parseInt(vista.getTxtGastosComunes().getText());
            return new Departamento(id, tipo, direccion, arriendo, metros, numPiso, gastos);
        }
    }
    private void refrescarTablas(){
        vista.getTvPropiedades().setItems(FXCollections.observableArrayList(manager.ListarTodas()));
        vista.getTvCasa().setItems(FXCollections.observableArrayList(manager.listarCasas()));
        vista.getTvDepartamento().setItems(FXCollections.observableArrayList(manager.listarDepartamentos()));
    }

    private void alertas(AlertType tipo, String mensaje){
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
}
