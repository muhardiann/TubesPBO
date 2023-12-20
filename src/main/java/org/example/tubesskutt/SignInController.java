package org.example.tubesskutt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class SignInController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    public void onKembali(ActionEvent event) {
        try {
            // Jika tombol ditekan, beralih ke Menu.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Menu - POOH");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateCredentials(String username, String password) {
        return username.equals("kemana") && password.equals("dimana");
    }

    @FXML
    protected void handleSignIn(ActionEvent event) {
        signIn();
    }

    // Method untuk validasi dan aksi sign-in
    private void signIn() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateCredentials(username, password)) {
            try {
                File file = new File("data.txt");
                if (file.exists()) {
                    // Membuka file data.txt
                    java.awt.Desktop.getDesktop().open(file);
                } else {
                    System.out.println("File tidak ditemukan: " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username atau password tidak sesuai!");
            alert.showAndWait();
        }
    }

    // Method initialize untuk menambahkan event listener
    public void initialize() {
        usernameField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                signIn();
            }
        });

        passwordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                signIn();
            }
        });
    }
}