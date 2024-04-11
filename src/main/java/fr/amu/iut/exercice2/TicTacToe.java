package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;


public class TicTacToe extends Application {



    public Node aleatoire(){
        ImageView image = new ImageView("exercice2/Croix.png");
        ImageView image2 = new ImageView("exercice2/Rond.png");
        ImageView image3 = new ImageView("exercice2/Vide.png");
        Random random = new Random();
        int nombrealea = random.nextInt(3);

        if(nombrealea==0){
            return image2;
        } else if (nombrealea==1) {
            return image;

        }
        else{
            return image3;
        }
    }




    @Override
    public void start(Stage primaryStage) {


        BorderPane borderpane = new BorderPane();
        GridPane gridpane = new GridPane();
        Label label = new Label();


        GridPane gridpaneee = new GridPane();

        gridpaneee.add(aleatoire(),0,0);
        gridpaneee.add(aleatoire(),0,1);
        gridpaneee.add(aleatoire(),0,2);
        gridpaneee.add(aleatoire(),1,0);
        gridpaneee.add(aleatoire(),1,1);
        gridpaneee.add(aleatoire(),1,2);
        gridpaneee.add(aleatoire(),2,0);
        gridpaneee.add(aleatoire(),2,1);
        gridpaneee.add(aleatoire(),2,2);

        gridpaneee.setGridLinesVisible(true);

        borderpane.getChildren().add(gridpaneee);

        Scene scene = new Scene(borderpane );
        primaryStage.setScene( scene );
        primaryStage.setWidth( 130 );
        primaryStage.setHeight( 170 );
        primaryStage.setTitle("Tic Tac Toe");

// Affichage de la fenêtre
        primaryStage.show();

        primaryStage.show();
    }
}

