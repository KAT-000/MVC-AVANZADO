package com.seba.controlador;

import java.util.List;

import com.seba.manager.PokedexManager;
import com.seba.modelo.Pokemon;
import com.seba.vista.PokedexVista;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;

public class PokedexController {

    private PokedexVista vista;
    private PokedexManager manager;

    public PokedexController(PokedexVista vista, PokedexManager manager){
        this.vista = vista;
        this.manager = manager;

        actualizarTabla(manager.obtenerTodos());

        this.vista.getBtnRegistrar().setOnAction(e -> registrarPokemon());
        this.vista.getBtnLimpiar().setOnAction(e -> limpiarCampos());
        this.vista.getBtnEliminar().setOnAction(e -> eliminarSeleccionado());
        this.vista.getTxtBuscador().setOnKeyReleased(e -> filtrarTabla());
        this.vista.getCbFiltroCategoria().setOnAction(e -> filtrarTabla());
    }

    private void registrarPokemon(){
        try{
            String categoria = vista.getCbCategoria().getValue();
            String nombre = vista.getTxtNombre().getText();
            String habilidad = vista.getTxtHabilidad().getText();
            int hp = Integer.parseInt(vista.getTxtHp().getText());
            int ataque = Integer.parseInt(vista.getTxtAtaque().getText());
            int defensa = Integer.parseInt(vista.getTxtDefensa().getText());
            int atEspecial = Integer.parseInt(vista.getTxtAtaqueEspecial().getText());
            int defEspecial = Integer.parseInt(vista.getTxtDefensaEspecial().getText());
            int velocidad = Integer.parseInt(vista.getTxtVelocidad().getText());

            if ("Normal".equals(categoria)) {
                int nivelEvo = Integer.parseInt(vista.getTxtNivelEvolucion().getText());
                manager.agregarNormal(nombre, habilidad, hp, ataque, defensa, atEspecial, defEspecial, velocidad, nivelEvo);
            } else if ("PseudoLegendario".equals(categoria)) {
                String etapa = vista.getTxtEtapaEvolutiva().getText();
                manager.agregarPseudo(nombre, habilidad, hp, ataque, defensa, atEspecial, defEspecial, velocidad, etapa);
            } else if ("Legendario".equals(categoria)) {
                String region = vista.getTxtRegionExclusiva().getText();
                boolean esMitico = vista.getChkEsMitico().isSelected();
                manager.agregarLegendario(nombre, habilidad, hp, ataque, defensa, atEspecial, defEspecial, velocidad, region, esMitico);
            }
        actualizarTabla(manager.obtenerTodos());
        limpiarCampos();
        vista.getLblEstado().setText("Pokemon registrado con exito!");
        } catch (NumberFormatException ex) {mostrarAlerta("Error de formato", "Las estadisticas base y el nivel solo deben ser numeros enteros.");

        } catch (Exception ex) {
            mostrarAlerta("Error de validacion", ex.getMessage());
        }
    }

    private void eliminarSeleccionado(){
        try {
            Pokemon seleccionado = vista.getTablaPokemon().getSelectionModel().getSelectedItem();
            manager.eliminarPokemon(seleccionado);
            actualizarTabla(manager.obtenerTodos());
            vista.getLblEstado().setText("Pokemon eliminado correctamente.");
        } catch (Exception ex) {mostrarAlerta("Atencion ", ex.getMessage());}
    }

    private void filtrarTabla() {
        String texto = vista.getTxtBuscador().getText();
        String categoria = vista.getCbCategoria().getValue();
        actualizarTabla(manager.buscarYFiltrar(texto, categoria));
    }

    private void actualizarTabla(List<Pokemon> lista) {
        vista.getTablaPokemon().setItems(FXCollections.observableArrayList(lista));
    }

    private void limpiarCampos() {

        vista.getTxtNombre().clear();
        vista.getTxtHabilidad().clear();
        vista.getTxtHp().clear();
        vista.getTxtAtaque().clear();
        vista.getTxtDefensa().clear();
        vista.getTxtAtaqueEspecial().clear();
        vista.getTxtDefensaEspecial().clear();
        vista.getTxtVelocidad().clear();
        vista.getTxtNivelEvolucion().clear();
        vista.getTxtEtapaEvolutiva().clear();
        vista.getTxtRegionExclusiva().clear();
        vista.getChkEsMitico().setSelected(false);

    }

    private void mostrarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
