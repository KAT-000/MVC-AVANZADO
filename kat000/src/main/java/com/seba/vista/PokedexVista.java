package com.seba.vista;

import com.seba.modelo.Pokemon;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class PokedexVista extends HBox {

    private ComboBox<String> cbCategoria = new ComboBox<>();
    private CheckBox chkEsMitico =  new CheckBox("¿Es Mitico / Singular?");

    private Label lblNombre = new Label("Nombre del pokemon: ");
    private Label lblHabilidad = new Label("Habilidad del pokemon: ");
    private Label lblHp = new Label("Hp: ");
    private Label lblAtaque = new Label("Ataque: ");
    private Label lblDefensa = new Label("Defensa: ");
    private Label lblAtaqueEspecial = new Label("Ataque Especial: ");
    private Label lblDefensaEspecial = new Label("Defensa Especial: ");
    private Label lblVelocidad = new Label("Velocidad: ");
    private Label lblNivelEvolucion = new Label("Nivel de evolucion: ");
    private Label lblEtapaEvolutiva = new Label("Etapa evolutiva: ");
    private Label lblRegionExclusiva = new Label("Region: ");

    private Label lblBuscador = new Label("Buscador ");
    private TextField txtBuscador = new TextField();
    private ComboBox<String> cbFiltroCategoria = new ComboBox<>();
    private TableView<Pokemon> tablaPokemon = new TableView<>();
    private Button btnEliminar = new Button("ELIMINAR");
    private Label lblEstado = new Label("Estado: "); 
    private Label lblCategoria = new Label("Categoria: ");
    private Button btnBuscar = new Button("BUSCAR");

    private TextField txtNombre = new TextField();
    private TextField txtHabilidad = new TextField();
    private TextField txtHp = new TextField();
    private TextField txtAtaque = new TextField();
    private TextField txtDefensa = new TextField();
    private TextField txtAtaqueEspecial = new TextField();
    private TextField txtDefensaEspecial = new TextField();
    private TextField txtVelocidad = new TextField();
    private TextField txtNivelEvolucion = new TextField();
    private TextField txtEtapaEvolutiva = new TextField();
    private TextField txtRegionExclusiva = new TextField();

    private Button btnRegistrar = new Button("REGISTRAR");
    private Button btnLimpiar = new Button("LIMPIAR");

    public PokedexVista(){

        cbCategoria.getItems().addAll("Normal", "PseudoLegendario", "Legendario");
        cbCategoria.setValue("Normal");

        cbFiltroCategoria.getItems().addAll("Todos", "Normal", "PseudoLegendario", "Legendario");
        cbFiltroCategoria.setValue("Todos");

        VBox panelFormulario = new VBox(10, lblCategoria ,cbCategoria, lblNombre, txtNombre,
        lblHabilidad, txtHabilidad, lblHp, txtHp, lblAtaque, txtAtaque, lblDefensa, txtDefensa, lblAtaqueEspecial, txtAtaqueEspecial,
        lblDefensaEspecial, txtDefensaEspecial, lblVelocidad, txtVelocidad, lblNivelEvolucion, txtNivelEvolucion, lblEtapaEvolutiva, txtEtapaEvolutiva,
        lblRegionExclusiva, txtRegionExclusiva, chkEsMitico, btnRegistrar, btnLimpiar);

        panelFormulario.setSpacing(10);

        VBox panelTabla = new VBox(10, lblBuscador, txtBuscador, btnBuscar, cbFiltroCategoria, tablaPokemon, btnEliminar, lblEstado);

        panelTabla.setSpacing(15);
        
        TableColumn<Pokemon, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Pokemon, String> colCategoria = new TableColumn<>("Categoria");
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        TableColumn<Pokemon, String> colHabilidad = new TableColumn<>("Habilidad");
        colHabilidad.setCellValueFactory(new PropertyValueFactory<>("ability"));

        TableColumn<Pokemon, Integer> colHp = new TableColumn<>("Hp");
        colHp.setCellValueFactory(new PropertyValueFactory<>("hp"));

        TableColumn<Pokemon, Integer> colAtaque = new TableColumn<>("Ataque");
        colAtaque.setCellValueFactory(new PropertyValueFactory<>("attack"));

        TableColumn<Pokemon, Integer> colDefensa = new TableColumn<>("Defensa");
        colDefensa.setCellValueFactory(new PropertyValueFactory<>("defense"));

        TableColumn<Pokemon, Integer> colAtaqueEspecial = new TableColumn<>("At.Esp");
        colAtaqueEspecial.setCellValueFactory(new PropertyValueFactory<>("specialAttack"));

        TableColumn<Pokemon, Integer> colDefensaEspecial = new TableColumn<>("Def.Esp");
        colDefensaEspecial.setCellValueFactory(new PropertyValueFactory<>("specialDefense"));

        TableColumn<Pokemon, Integer> colVelociad = new TableColumn<>("Velocidad");
        colVelociad.setCellValueFactory(new PropertyValueFactory<>("speed"));

        TableColumn<Pokemon, Double> colPoder = new TableColumn<>("Poder Total");
        colPoder.setCellValueFactory(new PropertyValueFactory<>("indicePoder"));


        tablaPokemon.getColumns().addAll(colNombre, colCategoria, colHabilidad, colHp, colAtaque, colDefensa,
        colAtaqueEspecial, colDefensaEspecial, colVelociad, colPoder);
        tablaPokemon.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        this.setSpacing(20);
        this.getChildren().addAll(panelFormulario, panelTabla);

        this.setPadding(new Insets(20));
        this.setSpacing(30);
    }

    public ComboBox<String> getCbCategoria() {
        return cbCategoria;
    }

    public void setCbCategoria(ComboBox<String> cbCategoria) {
        this.cbCategoria = cbCategoria;
    }

    public CheckBox getChkEsMitico() {
        return chkEsMitico;
    }

    public void setChkEsMitico(CheckBox chkEsMitico) {
        this.chkEsMitico = chkEsMitico;
    }

    public Label getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(Label lblNombre) {
        this.lblNombre = lblNombre;
    }

    public Label getLblHabilidad() {
        return lblHabilidad;
    }

    public void setLblHabilidad(Label lblHabilidad) {
        this.lblHabilidad = lblHabilidad;
    }

    public Label getLblHp() {
        return lblHp;
    }

    public void setLblHp(Label lblHp) {
        this.lblHp = lblHp;
    }

    public Label getLblAtaque() {
        return lblAtaque;
    }

    public void setLblAtaque(Label lblAtaque) {
        this.lblAtaque = lblAtaque;
    }

    public Label getLblDefensa() {
        return lblDefensa;
    }

    public void setLblDefensa(Label lblDefensa) {
        this.lblDefensa = lblDefensa;
    }

    public Label getLblAtaqueEspecial() {
        return lblAtaqueEspecial;
    }

    public void setLblAtaqueEspecial(Label lblAtaqueEspecial) {
        this.lblAtaqueEspecial = lblAtaqueEspecial;
    }

    public Label getLblDefensaEspecial() {
        return lblDefensaEspecial;
    }

    public void setLblDefensaEspecial(Label lblDefensaEspecial) {
        this.lblDefensaEspecial = lblDefensaEspecial;
    }

    public Label getLblVelocidad() {
        return lblVelocidad;
    }

    public void setLblVelocidad(Label lblVelocidad) {
        this.lblVelocidad = lblVelocidad;
    }

    public Label getLblNivelEvolucion() {
        return lblNivelEvolucion;
    }

    public void setLblNivelEvolucion(Label lblNivelEvolucion) {
        this.lblNivelEvolucion = lblNivelEvolucion;
    }

    public Label getLblEtapaEvolutiva() {
        return lblEtapaEvolutiva;
    }

    public void setLblEtapaEvolutiva(Label lblEtapaEvolutiva) {
        this.lblEtapaEvolutiva = lblEtapaEvolutiva;
    }

    public Label getLblRegionExclusiva() {
        return lblRegionExclusiva;
    }

    public void setLblRegionExclusiva(Label lblRegionExclusiva) {
        this.lblRegionExclusiva = lblRegionExclusiva;
    }

    public Label getLblBuscador() {
        return lblBuscador;
    }

    public void setLblBuscador(Label lblBuscador) {
        this.lblBuscador = lblBuscador;
    }

    public TextField getTxtBuscador() {
        return txtBuscador;
    }

    public void setTxtBuscador(TextField txtBuscador) {
        this.txtBuscador = txtBuscador;
    }

    public ComboBox<String> getCbFiltroCategoria() {
        return cbFiltroCategoria;
    }

    public void setCbFiltroCategoria(ComboBox<String> cbFiltroCategoria) {
        this.cbFiltroCategoria = cbFiltroCategoria;
    }

    public TableView<Pokemon> getTablaPokemon() {
        return tablaPokemon;
    }

    public void setTablaPokemon(TableView<Pokemon> tablaPokemon) {
        this.tablaPokemon = tablaPokemon;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(Button btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public Label getLblEstado() {
        return lblEstado;
    }

    public void setLblEstado(Label lblEstado) {
        this.lblEstado = lblEstado;
    }

    public Label getLblCategoria() {
        return lblCategoria;
    }

    public void setLblCategoria(Label lblCategoria) {
        this.lblCategoria = lblCategoria;
    }

    public Button getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(Button btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(TextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public TextField getTxtHabilidad() {
        return txtHabilidad;
    }

    public void setTxtHabilidad(TextField txtHabilidad) {
        this.txtHabilidad = txtHabilidad;
    }

    public TextField getTxtHp() {
        return txtHp;
    }

    public void setTxtHp(TextField txtHp) {
        this.txtHp = txtHp;
    }

    public TextField getTxtAtaque() {
        return txtAtaque;
    }

    public void setTxtAtaque(TextField txtAtaque) {
        this.txtAtaque = txtAtaque;
    }

    public TextField getTxtDefensa() {
        return txtDefensa;
    }

    public void setTxtDefensa(TextField txtDefensa) {
        this.txtDefensa = txtDefensa;
    }

    public TextField getTxtAtaqueEspecial() {
        return txtAtaqueEspecial;
    }

    public void setTxtAtaqueEspecial(TextField txtAtaqueEspecial) {
        this.txtAtaqueEspecial = txtAtaqueEspecial;
    }

    public TextField getTxtDefensaEspecial() {
        return txtDefensaEspecial;
    }

    public void setTxtDefensaEspecial(TextField txtDefensaEspecial) {
        this.txtDefensaEspecial = txtDefensaEspecial;
    }

    public TextField getTxtVelocidad() {
        return txtVelocidad;
    }

    public void setTxtVelocidad(TextField txtVelocidad) {
        this.txtVelocidad = txtVelocidad;
    }

    public TextField getTxtNivelEvolucion() {
        return txtNivelEvolucion;
    }

    public void setTxtNivelEvolucion(TextField txtNivelEvolucion) {
        this.txtNivelEvolucion = txtNivelEvolucion;
    }

    public TextField getTxtEtapaEvolutiva() {
        return txtEtapaEvolutiva;
    }

    public void setTxtEtapaEvolutiva(TextField txtEtapaEvolutiva) {
        this.txtEtapaEvolutiva = txtEtapaEvolutiva;
    }

    public TextField getTxtRegionExclusiva() {
        return txtRegionExclusiva;
    }

    public void setTxtRegionExclusiva(TextField txtRegionExclusiva) {
        this.txtRegionExclusiva = txtRegionExclusiva;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(Button btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public Button getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(Button btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    
    
}
