package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création d'un conteneur VBox avec ses éléments centrés
        root = new BorderPane();
        bas = new HBox(10);
        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");
        bas.getChildren().addAll( bleu,rouge,vert );
        bas.setAlignment(Pos.CENTER);
        root.setBottom(bas);
        panneau = new Pane();

        root.setCenter(panneau);
        label = new Label();
        label.setAlignment(Pos.CENTER);
        root.setTop(label);
        BorderPane.setAlignment(label,Pos.CENTER);

        vert.setOnAction(e -> {
            nbVert++;
        });
        bleu.setOnAction(e -> {
            nbBleu++;
        });
        rouge.setOnAction(e -> {
            nbRouge++;
        });

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            label.setText( vert.getText()+" choisi " + nbVert + " fois");
            panneau.setStyle("-fx-background-color : green");
        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            label.setText( bleu.getText()+" choisi " + nbBleu + " fois");
            panneau.setStyle("-fx-background-color : blue");
        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            label.setText( rouge.getText()+" choisi " + nbRouge + " fois");
            panneau.setStyle("-fx-background-color : red");
        });

        // Ajout de la scene à la fenêtre
        bas.setPadding(new Insets(10.0d));
        Scene scene = new Scene( root );
        primaryStage.setScene( scene );

        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}



