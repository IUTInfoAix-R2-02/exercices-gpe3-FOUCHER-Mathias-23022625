package fr.amu.iut.exercice14;

import javafx.beans.property.*;

public class Personne {

    private String nom;
    private IntegerProperty age;
    private StringProperty villeDeNaissance;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = new SimpleIntegerProperty(age);
        this.villeDeNaissance = new SimpleStringProperty("Paris");
    }

    public int getAge() {
        return age.getValue();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setVilleDeNaissance(String ville) {
        villeDeNaissance.setValue(ville);
    }
    public void setAge(int age) {
        this.age.setValue(age);
    }
}
