package org.example.tubesskutt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    protected void onLaporButtonClick(ActionEvent event) {
        try {
            // Jika tombol ditekan, beralih ke SignIn.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lapor.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Lapor - POOH");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onDataButtonClick(ActionEvent event) {
        try {
            // Jika tombol ditekan, beralih ke SignIn.fxml
            Parent menuRoot = FXMLLoader.load(getClass().getResource("ListPencarian.fxml"));
            Scene scene = new Scene(menuRoot, 1920.0, 950.0);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("List Pencarian - POOH");
            Screen screen = Screen.getPrimary();
            double screenWidth = screen.getVisualBounds().getWidth();
            double screenHeight = screen.getVisualBounds().getHeight();

            // Set the scene dimensions and position to fit the screen
            stage.setScene(scene);
            stage.setX(screen.getVisualBounds().getMinX());
            stage.setY(screen.getVisualBounds().getMinY());
            stage.setWidth(screenWidth);
            stage.setHeight(screenHeight);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onSignInButtonClick(ActionEvent event) {
        try {
            // Jika tombol ditekan, beralih ke SignIn.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Sign In - POOH");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}