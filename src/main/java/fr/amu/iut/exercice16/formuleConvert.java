package fr.amu.iut.exercice16;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;

public class formuleConvert {

    public static void BindSlider(Slider cel, Slider fahr) {
        cel.valueProperty().addListener((observable, oldValue, newValue) -> {
            double fahrenheit = newValue.doubleValue() * 9 / 5 + 32;
            fahr.setValue(fahrenheit);
        });

        fahr.valueProperty().addListener((observable, oldValue, newValue) -> {
            double celsius = (newValue.doubleValue() - 32) * 5 / 9;
                cel.setValue(celsius);
        });
    }
}
