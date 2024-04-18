package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {
    private String lettresDevinees = "";
    private int tentativesRestantes;
    private Label motcacherOnScreen;
    Label tentativesRestes;
    private Button devinerButton = new Button("Devinez");

    ImageView imageView;

    private void updateTentativesLabel(Label tentativesRestes) {
        tentativesRestes.setText("Tentatives restantes : " + tentativesRestantes);
    }

    private String updateMotCacheLabel(String motCache) {
        String nvMot = "";
        for (char c : motCache.toCharArray()) {
            if (lettresDevinees.contains(String.valueOf(c))) {
                nvMot.indent(c);
            } else {
                nvMot.indent(Integer.parseInt("*"));
            }
        }
        motcacherOnScreen.setText(nvMot);
        return nvMot;
    }
    private void checkFinJeu() {
//        if (motCache.chars().allMatch(c -> lettresDevinees.contains(String.valueOf((char) c)))) {
//            gameOver("Vous avez gagné !",entre);
//        } else if (tentativesRestantes == 0) {
//            gameOver("Vous avez perdu. Le mot était : " + motCache);
//        }
    }

    private void gameOver(String message,TextField entreUtili,Label tentativesRestes ) {
        entreUtili.setDisable(true);
        tentativesRestes.setText(message);
    }

    private void updateImg(){
        Image imagedeRemplacement= new Image("exercice6/pendu"+tentativesRestantes+".png");
        imageView.setImage(imagedeRemplacement);
        System.out.println(tentativesRestantes);
    }

    private void devinerLettre(TextField entreUtili,Label motADecorous,Label tentativesRestes) {
        String lettre = entreUtili.getText().toLowerCase();
        if (lettre.length() == 1 && Character.isLetter(lettre.charAt(0))) {
            if (!lettresDevinees.contains(lettre)) {
                lettresDevinees += lettre;
                updateMotCacheLabel(lettre);
                if (!motADecorous.getText().contains(lettre)) {
                    tentativesRestantes--;
                    updateImg();
                    updateTentativesLabel(tentativesRestes);
                }

            }
        }
        entreUtili.clear();
        checkFinJeu();
    }
    @Override

    public void start(Stage primaryStage) throws Exception {
        VBox jeux = new VBox();
        Dico dico = new Dico();
        //nb vie et affichage image
        tentativesRestantes = 7;
        imageView = new ImageView("exercice6/pendu"+tentativesRestantes+".png");

        HBox MotauMilieu = new HBox();
        Label motadec = new Label("Mot a decouvrir :");
        Label motADecorous = new Label(dico.getMot());
        String motcacher = new String();
        for(int i= 0;i<motADecorous.getText().length();i++){
            motcacher+="*";
        }
        motcacherOnScreen = new Label(motcacher);
        MotauMilieu.setAlignment(Pos.CENTER);
        MotauMilieu.getChildren().addAll(motadec,motcacherOnScreen);

        tentativesRestes =new Label();
        updateTentativesLabel(tentativesRestes);


        TextField entreUtili = new TextField("allez y testez :)");
        jeux.setAlignment(Pos.CENTER);
        jeux.setStyle("-fx-background-color: green");

        devinerButton.setOnAction(e -> devinerLettre(entreUtili,motADecorous,tentativesRestes));

        jeux.getChildren().addAll(imageView,tentativesRestes,MotauMilieu,motADecorous,entreUtili,devinerButton);




        Scene scene = new Scene( jeux );
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        // A completer

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
