package com.trabajoprofe;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
    private static final String USUARIO = "usuario_desarrollador";
    private static final String CONTRASEÑA = "123456";

    private TableView<Juego> tablaJuegos;
    private TextField txtNombre, txtPrecio;
    private ComboBox<String> cmbConsola;
    private Label lblEstado;
    private int idSeleccionado = -1;

    @Override 
    public void start(Stage primaryStage) {

        tablaJuegos = new TableView<>();

        txtNombre = new TextField();
        txtPrecio = new TextField();

        txtNombre.setPromptText("Nombre del juego");
        txtPrecio.setPromptText("Precio del juego");

        cmbConsola = new ComboBox<>();
        cmbConsola.getItems().addAll("PC", "PS5", "Nintendo Switch", "Xbox");
        cmbConsola.setPromptText("Ingresa la consola");

        Button btnGuardar = new Button("GUARDAR");
        Button btnActualizar = new Button("ACTUALIZAR");
        Button btnEliminar = new Button("ELIMINAR");
        Button btnLimpiar = new Button("LIMPIAR");


        btnGuardar.setOnAction(e -> insertarJuego());
        btnActualizar.setOnAction(e -> actualizarJuego());
        btnEliminar.setOnAction(e -> eliminarJuego());
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        lblEstado = new Label("Listo");
        HBox botones = new HBox(10, btnGuardar, btnActualizar, btnEliminar, btnLimpiar);
        VBox panel = new VBox(10, new Label("Tarea profe carlitos"), txtNombre, txtPrecio, cmbConsola, botones, lblEstado);

        tablaJuegos.getSelectionModel().selectedItemProperty().addListener((obs, ant, sel) -> {

            if (sel != null) {
                idSeleccionado = sel.getId();
                txtNombre.setText(sel.getNombre());
                txtPrecio.setText(String.valueOf(sel.getPrecio()));
            }
        });

        TableColumn<Juego, Integer> colId = new TableColumn<>("ID");
        TableColumn<Juego, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Juego, Integer> colPrecio = new TableColumn<>("Precio");
        TableColumn<Juego, String> colConsola = new TableColumn<>("Plataforma");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaJuegos.getColumns().addAll(colId,colNombre,colPrecio,colConsola);

        HBox root = new HBox(20, panel, tablaJuegos);
        root.setPadding(new Insets(20));

        cargarJuegos();
        primaryStage.setTitle("trabajo - Sebastian Cordero");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void cargarJuegos(){
        ObservableList<Juego> lista = FXCollections.observableArrayList();
        String sql = "SELECT id, nombre, precio, consola FROM juegos ORDER BY id ASC";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA); 
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Juego j = new Juego(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getString("consola")
                    );
                    lista.add(j);
                } tablaJuegos.setItems(lista);
            } catch (SQLException e) {
                System.out.println("ERROR al cargar: " + e.getMessage());
            } 

    }

    private void insertarJuego() {

        String sql = "INSERT INTO juegos (nombre, precio, consola) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, txtNombre.getText().trim());
                ps.setInt(2, Integer.parseInt(txtPrecio.getText().trim()));
                ps.setString(3, cmbConsola.getValue());

                ps.executeUpdate();
                lblEstado.setText("Juego Guardado en la base de datos");
                limpiarFormulario();
                cargarJuegos();
        } catch (Exception e) {lblEstado.setText("Error al guardar el juego: " + e.getMessage());

        }

    }

    public void actualizarJuego() {
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona un juegos en la tabla");
            return;
        }
        String sql = "UPDATE juegos SET nombre = ?, precio = ?, consola = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            PreparedStatement ps = conn.prepareStatement(sql)) {
                
                ps.setString(1, txtNombre.getText().trim());
                ps.setInt(2, Integer.parseInt(txtPrecio.getText().trim()));
                ps.setString(3, cmbConsola.getValue());
                ps.setInt(4, idSeleccionado);

                ps.executeUpdate();
                lblEstado.setText("Base de datos actualizada");
                limpiarFormulario();
                cargarJuegos();
        } catch (Exception e) {lblEstado.setText("Error al actualizar el juego: " + e.getMessage());

        }

    }

    public void eliminarJuego() {

         if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona un juego en la tabla");
            return;
        }
        String sql = "DELETE FROM juegos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            PreparedStatement ps = conn.prepareStatement(sql)) {
                
                ps.setInt(1, idSeleccionado);
                ps.executeUpdate();
                lblEstado.setText("Juego eliminado de la base de datos");
                limpiarFormulario();
                cargarJuegos();
        } catch (Exception e) {lblEstado.setText("Error al eliminar el juego: " + e.getMessage());

        }
    }

    private void limpiarFormulario() {

        idSeleccionado = -1;
        txtNombre.clear();
        txtPrecio.clear();
        cmbConsola.setValue(null);
        tablaJuegos.getSelectionModel().clearSelection();


    }


    public static Connection obtenerConexion() throws SQLException {

        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            
    }

    public static void main(String[] args) {

        try (Connection conn = obtenerConexion()) {
            System.out.println("CONEXION EXITOSA");
        } catch (SQLException e) {System.out.println("ERROR AL CONECTAR: " + e.getMessage());}


        launch(args);
    }



}