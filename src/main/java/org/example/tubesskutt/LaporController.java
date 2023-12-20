package org.example.tubesskutt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LaporController {
    @FXML
    private TextField nama;
    @FXML
    private TextField kelamin;
    @FXML
    private TextField alamat;
    @FXML
    private TextField tinggi;
    @FXML
    private TextField rambut;
    @FXML
    private TextField terlihat;

    @FXML
    public void onKembali(ActionEvent event) {
        try {
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
    public void Submit(KeyEvent event) {
        if (isDataComplete()) {
            String namaData = nama.getText();
            String kelaminData = kelamin.getText();
            String alamatData = alamat.getText();

            int tinggiData = 0;
            try {
                tinggiData = Integer.parseInt(tinggi.getText());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            String rambutData = rambut.getText();
            String terlihatData = terlihat.getText();

            String dataToWrite = "Nama\t\t\t: " + namaData + "\n" +
                    "Jenis Kelamin\t\t: " + kelaminData + "\n" +
                    "Alamat\t\t\t: " + alamatData + "\n" +
                    "Tinggi Badan\t\t: " + tinggiData + " cm" + "\n" +
                    "Ciri Rambut\t\t: " + rambutData + "\n" +
                    "Terakhir Terlihat\t: " + terlihatData + "\n\n";

            String filePath = "data.txt";

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true)); // Gunakan true untuk menambahkan
                writer.write(dataToWrite); //data baru
                writer.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Terimakasih sudah melapor, semoga beliau cepat ditemukan 😊");

                ButtonType menuButtonType = new ButtonType("Menu");
                ButtonType laporButtonType = new ButtonType("Lapor lagi");

                alert.getButtonTypes().setAll(menuButtonType, laporButtonType);
                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType == menuButtonType) {
                        navigateToMenu(event);
                    } else if (buttonType == laporButtonType) {
                        alert.close();
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
            nama.clear();
            kelamin.clear();
            alamat.clear();
            tinggi.clear();
            rambut.clear();
            terlihat.clear();
        } else {
            showIncompleteDataAlert();
        }

    }

    private boolean isDataComplete() {
        return !nama.getText().isEmpty() &&
                !kelamin.getText().isEmpty() &&
                !alamat.getText().isEmpty() &&
                !tinggi.getText().isEmpty() &&
                !rambut.getText().isEmpty() &&
                !terlihat.getText().isEmpty();
    }
    private void showIncompleteDataAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Data tidak lengkap!");
        alert.showAndWait();
    }

    private void navigateToMenu(KeyEvent event) {
        try {
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
    public void initialize() {
        // Attach key event handlers for each text field
        nama.setOnKeyPressed(event -> handleEnter(event, nama));
        kelamin.setOnKeyPressed(event -> handleEnter(event, kelamin));
        alamat.setOnKeyPressed(event -> handleEnter(event, alamat));
        tinggi.setOnKeyPressed(event -> handleEnter(event, tinggi));
        rambut.setOnKeyPressed(event -> handleEnter(event, rambut));
        terlihat.setOnKeyPressed(event -> handleEnter(event, terlihat));
    }

    private void handleEnter(KeyEvent event, TextField field) {
        if (event.getCode() == KeyCode.ENTER) {
            // Submit when Enter is pressed in any text field
            Submit(event);
        }
    }
}
