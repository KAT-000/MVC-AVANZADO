package com.seba.vista;

import com.seba.modelo.Participante;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TorneoVista extends HBox {


    private Label lblRut = new Label("RUT:");
    private Label lblNickname = new Label("Nickname:");
    private Label lblNombres = new Label("Nombres:"); 
    private Label lblApellidoPaterno = new Label("Apellido Paterno:");
    private Label lblApellidoMaterno = new Label("Apellido Materno:");
    private Label lblCorreo = new Label("Correo Electronico:");

    private TextField txtRut = new TextField();
    private TextField txtNickname = new TextField();
    private TextField txtNombres = new TextField();
    private TextField txtApellidoPaterno = new TextField();
    private TextField txtApellidoMaterno = new TextField();
    private TextField txtCorreo = new TextField();

    private Label lblTipoJugador = new Label("Tipo De Jugador:");
    private ComboBox<String> cmbTipoJugador = new ComboBox<>();

    private Label lblJuegoPrincipal = new Label("Juego Principal:");
    private Label lblRangoActual = new Label("Rango Actual:");
    private Label lblHorasEntrenamiento = new Label("Horas De Entrenamiento:");

    private TextField txtJuegoPrincipal = new TextField();
    private TextField txtRangoActual = new TextField();
    private TextField txtHorasEntrenamiento = new TextField();

    private Label lblEquipoOficial = new Label("Equipo Oficial:");
    private Label lblSueldoBase = new Label("Sueldo Base:");
    private Label lblTorneosGanados = new Label("Torneos Ganados:");

    private TextField txtEquipoOficial = new TextField();
    private TextField txtSueldoBase = new TextField();
    private TextField txtTorneosGanados = new TextField();

    private Button btnRegistrar = new Button("REGISTRAR");
    private TableView<Participante> tablaParticipantes = new TableView<>();

    public TorneoVista(){
        cmbTipoJugador.getItems().addAll("Amateur","Pro");
        cmbTipoJugador.setValue("Amateur");

        TableColumn<Participante, String> colRut = new TableColumn<>("RUT");
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));

        TableColumn<Participante, String> colNickname = new TableColumn<>("Nickname");
        colNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));

        TableColumn<Participante, String> colNombre = new TableColumn<>("Nombre Completo");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));


        TableColumn<Participante, String> colCategoria = new TableColumn<>("Categoria");
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().obtenerBadgeCategoria()));

        TableColumn<Participante, Double> colCuota = new TableColumn<>("Cuota (CPL)");
        colCuota.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().calcularCuotaInscripcion()));

        tablaParticipantes.getColumns().addAll(colRut, colNickname, colNombre, colCategoria, colCuota);

        VBox formulario = new VBox(5,
            lblRut, txtRut, lblNickname, txtNickname, lblNombres, txtNombres, lblApellidoPaterno, txtApellidoPaterno,
            lblApellidoMaterno, txtApellidoMaterno, lblCorreo, txtCorreo, lblTipoJugador, cmbTipoJugador, lblJuegoPrincipal, txtJuegoPrincipal,
            lblRangoActual, txtRangoActual, lblHorasEntrenamiento, txtHorasEntrenamiento, lblEquipoOficial, txtEquipoOficial, lblSueldoBase, txtSueldoBase,
            lblTorneosGanados, txtTorneosGanados, btnRegistrar);
        
        this.setSpacing(15);
        HBox.setHgrow(tablaParticipantes, Priority.ALWAYS);
        tablaParticipantes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        this.getChildren().addAll(formulario, tablaParticipantes);
    }

    public Label getLblRut() {
        return lblRut;
    }

    public void setLblRut(Label lblRut) {
        this.lblRut = lblRut;
    }

    public Label getLblNickname() {
        return lblNickname;
    }

    public void setLblNickname(Label lblNickname) {
        this.lblNickname = lblNickname;
    }

    public Label getLblNombres() {
        return lblNombres;
    }

    public void setLblNombres(Label lblNombres) {
        this.lblNombres = lblNombres;
    }

    public Label getLblApellidoPaterno() {
        return lblApellidoPaterno;
    }

    public void setLblApellidoPaterno(Label lblApellidoPaterno) {
        this.lblApellidoPaterno = lblApellidoPaterno;
    }

    public Label getLblApellidoMaterno() {
        return lblApellidoMaterno;
    }

    public void setLblApellidoMaterno(Label lblApellidoMaterno) {
        this.lblApellidoMaterno = lblApellidoMaterno;
    }

    public Label getLblCorreo() {
        return lblCorreo;
    }

    public void setLblCorreo(Label lblCorreo) {
        this.lblCorreo = lblCorreo;
    }

    public TextField getTxtRut() {
        return txtRut;
    }

    public void setTxtRut(TextField txtRut) {
        this.txtRut = txtRut;
    }

    public TextField getTxtNickname() {
        return txtNickname;
    }

    public void setTxtNickname(TextField txtNickname) {
        this.txtNickname = txtNickname;
    }

    public TextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(TextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public TextField getTxtApellidoPaterno() {
        return txtApellidoPaterno;
    }

    public void setTxtApellidoPaterno(TextField txtApellidoPaterno) {
        this.txtApellidoPaterno = txtApellidoPaterno;
    }

    public TextField getTxtApellidoMaterno() {
        return txtApellidoMaterno;
    }

    public void setTxtApellidoMaterno(TextField txtApellidoMaterno) {
        this.txtApellidoMaterno = txtApellidoMaterno;
    }

    public TextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(TextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public Label getLblTipoJugador() {
        return lblTipoJugador;
    }

    public void setLblTipoJugador(Label lblTipoJugador) {
        this.lblTipoJugador = lblTipoJugador;
    }

    public ComboBox<String> getCmbTipoJugador() {
        return cmbTipoJugador;
    }

    public void setCmbTipoJugador(ComboBox<String> cmbTipoJugador) {
        this.cmbTipoJugador = cmbTipoJugador;
    }

    public Label getLblJuegoPrincipal() {
        return lblJuegoPrincipal;
    }

    public void setLblJuegoPrincipal(Label lblJuegoPrincipal) {
        this.lblJuegoPrincipal = lblJuegoPrincipal;
    }

    public Label getLblRangoActual() {
        return lblRangoActual;
    }

    public void setLblRangoActual(Label lblRangoActual) {
        this.lblRangoActual = lblRangoActual;
    }

    public Label getLblHorasEntrenamiento() {
        return lblHorasEntrenamiento;
    }

    public void setLblHorasEntrenamiento(Label lblHorasEntrenamiento) {
        this.lblHorasEntrenamiento = lblHorasEntrenamiento;
    }

    public TextField getTxtJuegoPrincipal() {
        return txtJuegoPrincipal;
    }

    public void setTxtJuegoPrincipal(TextField txtJuegoPrincipal) {
        this.txtJuegoPrincipal = txtJuegoPrincipal;
    }

    public TextField getTxtRangoActual() {
        return txtRangoActual;
    }

    public void setTxtRangoActual(TextField txtRangoActual) {
        this.txtRangoActual = txtRangoActual;
    }

    public TextField getTxtHorasEntrenamiento() {
        return txtHorasEntrenamiento;
    }

    public void setTxtHorasEntrenamiento(TextField txtHorasEntrenamiento) {
        this.txtHorasEntrenamiento = txtHorasEntrenamiento;
    }

    public Label getLblEquipoOficial() {
        return lblEquipoOficial;
    }

    public void setLblEquipoOficial(Label lblEquipoOficial) {
        this.lblEquipoOficial = lblEquipoOficial;
    }

    public Label getLblSueldoBase() {
        return lblSueldoBase;
    }

    public void setLblSueldoBase(Label lblSueldoBase) {
        this.lblSueldoBase = lblSueldoBase;
    }

    public Label getLblTorneosGanados() {
        return lblTorneosGanados;
    }

    public void setLblTorneosGanados(Label lblTorneosGanados) {
        this.lblTorneosGanados = lblTorneosGanados;
    }

    public TextField getTxtEquipoOficial() {
        return txtEquipoOficial;
    }

    public void setTxtEquipoOficial(TextField txtEquipoOficial) {
        this.txtEquipoOficial = txtEquipoOficial;
    }

    public TextField getTxtSueldoBase() {
        return txtSueldoBase;
    }

    public void setTxtSueldoBase(TextField txtSueldoBase) {
        this.txtSueldoBase = txtSueldoBase;
    }

    public TextField getTxtTorneosGanados() {
        return txtTorneosGanados;
    }

    public void setTxtTorneosGanados(TextField txtTorneosGanados) {
        this.txtTorneosGanados = txtTorneosGanados;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(Button btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public TableView<Participante> getTablaParticipantes() {
        return tablaParticipantes;
    }

    public void setTablaParticipantes(TableView<Participante> tablaParticipantes) {
        this.tablaParticipantes = tablaParticipantes;
    }

    
}
