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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
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
    public void Submit(ActionEvent event) {
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
            ButtonType listButtonType = new ButtonType("Lihat list");

            alert.getButtonTypes().setAll(menuButtonType, listButtonType);
            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == menuButtonType) {
                    navigateToMenu(event);
                } else if (buttonType == listButtonType) {
                    openFile(filePath);
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
    }

    private void navigateToMenu(ActionEvent event) {
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

    private void openFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                // Code to open the data.txt file
                // Using Desktop to open the file in the default system editor
                java.awt.Desktop.getDesktop().open(file);
            } else {
                System.out.println("File not found: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
