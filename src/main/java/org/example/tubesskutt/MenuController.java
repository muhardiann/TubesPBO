package org.example.tubesskutt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
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

//        try {
//            File file = new File("data.txt");
//            if (file.exists()) {
//                // Membuka file data.txt
//                java.awt.Desktop.getDesktop().open(file);
//            } else {
//                System.out.println("File tidak ditemukan: " + file.getAbsolutePath());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }