package com.estudio;

import com.estudio.controlador.InmoviliariaControlador;
import com.estudio.vista.InmoviliariaVista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override 
    public void start(Stage primaryStage){
        InmoviliariaVista vista = new InmoviliariaVista();
        new InmoviliariaControlador(vista);

        Scene scene = new Scene(vista, 1650, 620); 
        primaryStage.setTitle("¡Inmoviliaria Suprema!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}