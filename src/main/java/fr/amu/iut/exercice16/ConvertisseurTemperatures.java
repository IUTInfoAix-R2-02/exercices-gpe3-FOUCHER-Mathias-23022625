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

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        //celsius
        Text nomCelsius = new Text("°C");
        Slider celsiusSlider = new Slider(0, 100, 0);
        celsiusSlider.setOrientation(Orientation.VERTICAL);
        //pour la graduation
        celsiusSlider.setShowTickMarks(true);
        celsiusSlider.setShowTickLabels(true);
        celsiusSlider.setMajorTickUnit(10);
        celsiusSlider.setMinorTickCount(3);
        celsiusSlider.setBlockIncrement(1);
        celsiusSlider.setPrefHeight(1000);

        //fahrenheit
        Text nomFahrenheit = new Text("°F");
        nomFahrenheit.setTextAlignment(TextAlignment.CENTER);
        Slider fahrenheitSlider = new Slider(0, 212, 32);
        fahrenheitSlider.setOrientation(Orientation.VERTICAL);
        fahrenheitSlider.setShowTickMarks(true);
        fahrenheitSlider.setShowTickLabels(true);
        fahrenheitSlider.setMajorTickUnit(10);
        fahrenheitSlider.setMinorTickCount(3);
        fahrenheitSlider.setBlockIncrement(1);
        fahrenheitSlider.setPrefHeight(1000);







        //les box qui indiquent le degres
        TextField celsiusTextField = new TextField();
        TextField fahrenheitTextField = new TextField();

        //les 2 bindings pour que le slider et le text soient raccord
        Bindings.bindBidirectional(celsiusTextField.textProperty(), celsiusSlider.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(fahrenheitTextField.textProperty(), fahrenheitSlider.valueProperty(), new NumberStringConverter());



        //listener pour que les degres celsius et fahrenight bougent en meme temps
        celsiusSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double fahrenheit = newValue.doubleValue() * 9 / 5 + 32;
            fahrenheitSlider.setValue(fahrenheit);
        });

        fahrenheitSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double celsius = (newValue.doubleValue() - 32) * 5 / 9;
            celsiusSlider.setValue(celsius);
        });




        //on met tout dans des Vbox pour que le nom,le slider et et le TextField soient alignés
        VBox panneauCelsius = new VBox(25, nomCelsius,celsiusSlider ,celsiusTextField);
        panneauCelsius.setAlignment(Pos.CENTER);
        VBox panneauFahrenheit = new VBox(25, nomFahrenheit,fahrenheitSlider, fahrenheitTextField);
        panneauFahrenheit.setAlignment(Pos.CENTER);

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
