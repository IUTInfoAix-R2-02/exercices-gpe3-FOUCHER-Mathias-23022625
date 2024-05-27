package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.text.NumberFormat;

public class ConvertisseurTemperatures extends Application {

    public Slider creationSlider(int min, int max, int initialValue) {
        Slider slider = new Slider(min, max, initialValue);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(3);
        slider.setBlockIncrement(1);
        slider.setPrefHeight(600);
        return slider;
    }
    @Override
    public void start(Stage primaryStage) {
        Text TitreCelsius = new Text("°C");
        Text TitreFahrenheit = new Text("°F");
        //appelle de la fonction pour créer les sliders avec les bons parametres
        Slider celsiusSlider = creationSlider(0, 100, 0);
        Slider fahrenheitSlider = creationSlider(0, 212, 32);

        //les box qui indiquent le degres
        TextField celsiusTextField = new TextField();
        TextField fahrenheitTextField = new TextField();

        //les 2 bindings pour que le slider et le text soient raccord
        celsiusTextField.textProperty().bindBidirectional( celsiusSlider.valueProperty(), NumberFormat.getNumberInstance());
        fahrenheitTextField.textProperty().bindBidirectional( fahrenheitSlider.valueProperty(), NumberFormat.getNumberInstance());

        // on appelle notre fonction dans le fichier externe, les listeners sont directement dans la fonction
        formuleConvert.BindSlider(celsiusSlider, fahrenheitSlider);

        //on met tout dans des Vbox pour que le nom,le slider et et le TextField soient alignés
        VBox panneauCelsius = new VBox(25, TitreCelsius,celsiusSlider ,celsiusTextField);
        VBox panneauFahrenheit = new VBox(25, TitreFahrenheit,fahrenheitSlider, fahrenheitTextField);
        panneauFahrenheit.setAlignment(Pos.CENTER);
        panneauCelsius.setAlignment(Pos.CENTER);
        //On met nos 2 Vbox dans une HBox pour qu'elles soient alignées
        HBox screnPrincipal = new HBox(100, panneauCelsius, panneauFahrenheit);
        screnPrincipal.setPadding(new Insets(20));
        primaryStage.setScene(new Scene(screnPrincipal, 400, 800));
        primaryStage.setTitle("Exo 16 temperature");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
