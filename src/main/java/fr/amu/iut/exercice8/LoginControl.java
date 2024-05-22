package fr.amu.iut.exercice8;

import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControl extends GridPane {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField pwd;

    @FXML
    private void handleOk() {
        String username = usernameField.getText();
        String password = pwd.getText();
        System.out.println("Username: " + username);
        System.out.println("Password: " + "*".repeat(password.length()));
    }

    @FXML
    private void handleCancel() {
        usernameField.clear();
        pwd.clear();
    }
}