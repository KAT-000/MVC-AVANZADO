package com.seba;

import com.seba.Manager.TorneoManager;
import com.seba.controlador.TorneoController;
import com.seba.vista.TorneoVista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override 
    public void start(Stage primaryStage) {
        TorneoVista vista = new TorneoVista();
        TorneoManager modelo = new TorneoManager();
        TorneoController controlador = new TorneoController(modelo, vista);

        Scene scene = new Scene(vista, 850, 800);
        primaryStage.setTitle("Prueba");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}