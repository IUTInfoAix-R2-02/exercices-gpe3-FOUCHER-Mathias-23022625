package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private  IntegerProperty nbfois = new SimpleIntegerProperty();

    private BooleanProperty pasEncoreDeClic;

    public void createBindings() {
        createPasEncoreDeClicBinding();
        bindTextDuHaut();
    }

    private void createPasEncoreDeClicBinding() {
        pasEncoreDeClic = new SimpleBooleanProperty();
        pasEncoreDeClic.bind(Bindings.notEqual(0, nbfois));
    }

    private void bindTextDuHaut() {
        Label texteDuHaut = new Label();
        // Initial value is empty string, it changes to "Cliquez !" when pasEncoreDeClic is true
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic)
                .then("Cliquez !")
                .otherwise(""));
    }


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        texteDuHaut.setText("Cliquez sur un boutons");
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        nbfois = new SimpleIntegerProperty();
        StringProperty nomDuButton = new SimpleStringProperty();
        StringProperty couleurPanneau = new SimpleStringProperty("#000000");
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        texteDuBas.setText("Cliquez sur un boutons");
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbVert ++;
            nbfois.setValue(nbVert);
            nomDuButton.setValue("Vert");
            couleurPanneau.setValue("green");
        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbBleu ++;
            nbfois.setValue(nbBleu);
            nomDuButton.setValue("Bleu");
            couleurPanneau.setValue("blue");
        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbRouge ++;
            nbfois.setValue(nbRouge);
            nomDuButton.setValue("Rouge");
            couleurPanneau.setValue("red");
        });

        texteDuHaut.textProperty().bind(Bindings.concat(nomDuButton," choisi " , nbfois , " fois"));
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color : ",couleurPanneau));

        /* VOTRE CODE ICI */

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
