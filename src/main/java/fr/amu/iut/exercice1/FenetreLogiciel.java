package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        BorderPane borderPane = new BorderPane();

        // Création du conteneur correspondant à la ligne de contrôle haut dessus du tableau
        HBox topControls = new HBox();
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Edit");
        Menu menu3 = new Menu("Help");

        MenuItem menuItem = new MenuItem("New");
        MenuItem menuItem2 = new MenuItem("Open");
        MenuItem menuItem3 = new MenuItem("Save");
        MenuItem menuItem4 = new MenuItem("Close");
        MenuItem menuItem5 = new MenuItem("Cut");
        MenuItem menuItem6 = new MenuItem("Copy");
        MenuItem menuItem7 = new MenuItem("Paste");

        menu1.getItems().addAll(menuItem,menuItem2,menuItem3,menuItem4);
        menu2.getItems().addAll(menuItem5,menuItem6,menuItem7);


        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        topControls.getChildren().addAll(menuBar );


        GridPane gridPaneMid = new GridPane();
        Label midText1 = new Label("Name:");
        TextField midField1 = new TextField();
        Label midText2 = new Label("Email:");
        TextField midField2 = new TextField();
        Label midText3 = new Label("Password:");
        TextField midField3 = new TextField();
        Button btnMid = new Button("Submit");
        Button btnMid2 = new Button("Cancel");
        gridPaneMid.add(midText1,0,0);
        gridPaneMid.add(midField1,1,0);
        gridPaneMid.add(midText2,0,1);
        gridPaneMid.add(midField2,1,1);
        gridPaneMid.add(midText3,0,2);
        gridPaneMid.add(midField3,1,2);
        gridPaneMid.add(btnMid,0,3);
        gridPaneMid.add(btnMid2,1,3);
        gridPaneMid.setVgap(15);
        gridPaneMid.setHgap(15);
        gridPaneMid.setAlignment(Pos.CENTER);
        HBox btnmid= new HBox(15);
        btnmid.getChildren().addAll(btnMid,btnMid2);
        btnmid.setAlignment(Pos.CENTER);
        VBox vboxdumid = new VBox(15);
        vboxdumid.getChildren().addAll(gridPaneMid,btnmid);
        vboxdumid.setAlignment(Pos.CENTER);





        HBox aGAUCHEEEE= new HBox();
        VBox aGauche = new VBox(15);
        Label leftText = new Label("Boutons : ");
        Button btnGauche = new Button("Bouton 1");
        Button btnGauche2 = new Button("Bouton 2");
        Button btnGauche3 = new Button("Bouton 1");
        Separator sep = new Separator(Orientation.VERTICAL);
        aGauche.getChildren().addAll( leftText,btnGauche,btnGauche2,btnGauche3);
        aGauche.setAlignment(Pos.CENTER);
        aGAUCHEEEE.getChildren().addAll(aGauche,sep);


        // Création de la ligne de séparation


        // Création du bandeau en bas de la fenêtre
        VBox bottomControls = new VBox();
        Separator sepBas = new Separator();
        Label bottomText = new Label("Mon Vier oh ");
        bottomControls.getChildren().addAll( sepBas,bottomText );
        bottomControls.setAlignment(Pos.CENTER);


        // Ajout des contrôleurs au conteneur principal
        borderPane.setTop(menuBar);
        borderPane.setCenter(vboxdumid);
        borderPane.setLeft(aGAUCHEEEE);
        borderPane.setBottom(bottomControls);



        // Ajout du conteneur à la scene
        Scene scene = new Scene(borderPane );

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

