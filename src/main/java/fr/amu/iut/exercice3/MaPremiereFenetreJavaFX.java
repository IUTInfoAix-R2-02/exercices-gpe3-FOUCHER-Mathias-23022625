package fr.amu.iut.exercice3;

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

public class MaPremiereFenetreJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création d'un conteneur VBox avec ses éléments centrés
        VBox vbox = new VBox();
        vbox.setAlignment( Pos.CENTER );

        // Création et ajout du label au conteneur
        Label helloLabel = new Label("Bonjour à tous !");
        vbox.getChildren().add( helloLabel );

        // Création de la scene
        Scene scene = new Scene( vbox );

        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );

        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
