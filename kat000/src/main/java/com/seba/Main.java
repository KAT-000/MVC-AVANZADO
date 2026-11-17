package com.seba;

import com.seba.controlador.PokedexController;
import com.seba.manager.PokedexManager;
import com.seba.vista.PokedexVista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override 
    public void start(Stage primaryStage) {
        PokedexVista vista = new PokedexVista();
        PokedexManager manager = new PokedexManager();
        new PokedexController(vista, manager);

        Scene scene = new Scene(vista, 1380, 920);
        primaryStage.setTitle("Pokedex POO - Registro y Gestion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}