package com.estudio.vista;

import com.estudio.modelo.Casa;
import com.estudio.modelo.Departamento;
import com.estudio.modelo.Propiedad;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InmoviliariaVista extends HBox {

    private ComboBox<String> cmbTipo = new ComboBox<>();
    private TableView<Propiedad> tvPropiedades = new TableView<>();
    private TableView<Casa> tvCasa = new TableView<>();
    private TableView<Departamento> tvDepartamento = new TableView<>();

    // DATOS GENERALES

    private Label lblTipo = new Label("TIPO DE PROPIEDAD");
    private Label lblDireccion = new Label("DIRECCION");
    private Label lblArriendo = new Label("ARRIENDO");
    private Label lblMetros2 = new Label("METROS CUADRADOS");

    private TextField txtDireccion = new TextField();
    private TextField txtArriendo = new TextField();
    private TextField txtMetros2 = new TextField();

    // ////////////////////////////////////////////////////////////////////////

    // DATOS EXCLUSIVOS DE LA CASA

    private Label lblCantidadPisos = new Label("CANTIDAD DE PISOS");
    private Label lblTienePatio = new Label("TIENE PATIO (?)");

    private TextField txtCantidadPisos = new TextField();
    private TextField txtTienePatio = new TextField();


    // ////////////////////////////////////////////////////////////////////////

    // DATOS EXCLUSIV0S DEL DEPARTAMENTO

    private Label lblNumeroDePiso = new Label("NUMERO DE PISO");
    private Label lblGastosComunes = new Label("GASTOS COMUNES");

    private TextField txtNumeroDePiso = new TextField();
    private TextField txtGastosComunes = new TextField();


    // ///////////////////////////////////////////////////////////////////////

    // CRUD

    private Button btnAgregar = new Button("AGREGAR");
    private Button btnEliminar = new Button("ELIMINAR");
    private Button btnActualizar = new Button("ACTUALIZAR");
    private Button btnLimpiar = new Button("LIMPIAR");

    // //////////////////////////////////////////////////////////////////////

    public InmoviliariaVista(){

        cmbTipo.getItems().addAll("CASA", "DEPARTAMENTO");
        cmbTipo.setValue("CASA");

        TableColumn<Propiedad, Integer> colId = new TableColumn<>("ID");
        TableColumn<Propiedad, Integer> colArriendo = new TableColumn<>("ARRIENDO");
        TableColumn<Propiedad, Integer> colMetros2 = new TableColumn<>("METROS2");
        TableColumn<Propiedad, String> colDireccion = new TableColumn<>("DIRECCION");
        TableColumn<Propiedad, String> colTipo = new TableColumn<>("TIPO DE PROPIEDAD");
        TableColumn<Propiedad, String> colDetalle = new TableColumn<>("DETALLE");
        TableColumn<Propiedad, String> colPago = new TableColumn<>("PAGO MENSUAL");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colArriendo.setCellValueFactory(new PropertyValueFactory<>("arriendo"));
        colMetros2.setCellValueFactory(new PropertyValueFactory<>("metrosCuadrados"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));
        colPago.setCellValueFactory(new PropertyValueFactory<>("pagoTotal"));

        TableColumn<Casa, Integer> colCantidadPisos = new TableColumn<>("CANTIDAD DE PISOS");
        TableColumn<Casa, Boolean> colTienePatio = new TableColumn<>("TIENE PATIO");

        colCantidadPisos.setCellValueFactory(new PropertyValueFactory<>("cantidadDePisos"));
        colTienePatio.setCellValueFactory(new PropertyValueFactory<>("tienePatio"));

        TableColumn<Departamento, Integer> colNumeroPiso = new TableColumn<>("PISO NUMERO");
        TableColumn<Departamento, Integer> colGastosComunes = new TableColumn<>("GASTOS COMUNES");

        colNumeroPiso.setCellValueFactory(new PropertyValueFactory<>("numeroDePiso"));
        colGastosComunes.setCellValueFactory(new PropertyValueFactory<>("gastosComunes"));

        tvPropiedades.getColumns().addAll(colId,colTipo,colDireccion,colMetros2,colArriendo, colDetalle, colPago);
        tvCasa.getColumns().addAll(colCantidadPisos, colTienePatio);
        tvDepartamento.getColumns().addAll(colNumeroPiso, colGastosComunes);

        VBox formulario = new VBox(10,lblTipo, cmbTipo, lblDireccion, txtDireccion, lblMetros2, txtMetros2,
        lblArriendo, txtArriendo, lblCantidadPisos, txtCantidadPisos, lblTienePatio, txtTienePatio, lblNumeroDePiso, txtNumeroDePiso,
        lblGastosComunes, txtGastosComunes);

        HBox tablas = new HBox(10,tvPropiedades, tvCasa, tvDepartamento);

        HBox crud = new HBox(10,btnAgregar, btnEliminar, btnActualizar, btnLimpiar);

        HBox root = new HBox(formulario, crud, tablas);
        root.setPadding(new Insets(20));
        
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.getChildren().add(root);

    }

    public ComboBox<String> getCmbTipo() {
        return cmbTipo;
    }

    public void setCmbTipo(ComboBox<String> cmbTipo) {
        this.cmbTipo = cmbTipo;
    }

    public TableView<Propiedad> getTvPropiedades() {
        return tvPropiedades;
    }

    public void setTvPropiedades(TableView<Propiedad> tvPropiedades) {
        this.tvPropiedades = tvPropiedades;
    }

    public TableView<Casa> getTvCasa() {
        return tvCasa;
    }

    public void setTvCasa(TableView<Casa> tvCasa) {
        this.tvCasa = tvCasa;
    }

    public TableView<Departamento> getTvDepartamento() {
        return tvDepartamento;
    }

    public void setTvDepartamento(TableView<Departamento> tvDepartamento) {
        this.tvDepartamento = tvDepartamento;
    }

    public Label getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(Label lblTipo) {
        this.lblTipo = lblTipo;
    }

    public Label getLblDireccion() {
        return lblDireccion;
    }

    public void setLblDireccion(Label lblDireccion) {
        this.lblDireccion = lblDireccion;
    }

    public Label getLblArriendo() {
        return lblArriendo;
    }

    public void setLblArriendo(Label lblArriendo) {
        this.lblArriendo = lblArriendo;
    }

    public Label getLblMetros2() {
        return lblMetros2;
    }

    public void setLblMetros2(Label lblMetros2) {
        this.lblMetros2 = lblMetros2;
    }

    public TextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(TextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public TextField getTxtArriendo() {
        return txtArriendo;
    }

    public void setTxtArriendo(TextField txtArriendo) {
        this.txtArriendo = txtArriendo;
    }

    public TextField getTxtMetros2() {
        return txtMetros2;
    }

    public void setTxtMetros2(TextField txtMetros2) {
        this.txtMetros2 = txtMetros2;
    }

    public Label getLblCantidadPisos() {
        return lblCantidadPisos;
    }

    public void setLblCantidadPisos(Label lblCantidadPisos) {
        this.lblCantidadPisos = lblCantidadPisos;
    }

    public Label getLblTienePatio() {
        return lblTienePatio;
    }

    public void setLblTienePatio(Label lblTienePatio) {
        this.lblTienePatio = lblTienePatio;
    }

    public TextField getTxtCantidadPisos() {
        return txtCantidadPisos;
    }

    public void setTxtCantidadPisos(TextField txtCantidadPisos) {
        this.txtCantidadPisos = txtCantidadPisos;
    }

    public TextField getTxtTienePatio() {
        return txtTienePatio;
    }

    public void setTxtTienePatio(TextField txtTienePatio) {
        this.txtTienePatio = txtTienePatio;
    }

    public Label getLblNumeroDePiso() {
        return lblNumeroDePiso;
    }

    public void setLblNumeroDePiso(Label lblNumeroDePiso) {
        this.lblNumeroDePiso = lblNumeroDePiso;
    }

    public Label getLblGastosComunes() {
        return lblGastosComunes;
    }

    public void setLblGastosComunes(Label lblGastosComunes) {
        this.lblGastosComunes = lblGastosComunes;
    }

    public TextField getTxtNumeroDePiso() {
        return txtNumeroDePiso;
    }

    public void setTxtNumeroDePiso(TextField txtNumeroDePiso) {
        this.txtNumeroDePiso = txtNumeroDePiso;
    }

    public TextField getTxtGastosComunes() {
        return txtGastosComunes;
    }

    public void setTxtGastosComunes(TextField txtGastosComunes) {
        this.txtGastosComunes = txtGastosComunes;
    }

    public Button getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(Button btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Button btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public Button getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(Button btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public Button getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(Button btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    
    
}
