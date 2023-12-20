package org.example.tubesskutt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class LaporController {
    @FXML
    public void onKembali(ActionEvent event) {
        try {
            // Jika tombol ditekan, beralih ke SignIn.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Submit(ActionEvent event) {
        // Menampilkan dialog overlay
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Terimakasih sudah melapor, semoga beliau cepat ditemukan 😊");

        ButtonType menuButtonType = new ButtonType("Menu");
        ButtonType listButtonType = new ButtonType("Lihat list");

        alert.getButtonTypes().setAll(menuButtonType, listButtonType);
        alert.setOnCloseRequest(e -> {
            // Handle what should happen when the alert is closed
            // For instance, close the application or perform any other action
        });
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == menuButtonType) {
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
            } else if (buttonType == listButtonType) {
                try {
                    // Jika tombol ditekan, beralih ke SignIn.fxml
                    Parent menuRoot = FXMLLoader.load(getClass().getResource("ListPencarian.fxml"));
                    Scene scene = new Scene(menuRoot, 1920.0, 1080.0);
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
        });
    }


}