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

public class ListPencarianController {

    int user_id ;
    String user_nama ;
    String user_kelamin;
    String user_alamat ;
    String user_tinggi ;
    String user_rambut ;
    String user_terlihat ;




    @FXML
    public void onKembali(ActionEvent event) {
        try {
            // Jika tombol ditekan, beralih ke Menu.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            // Create a scene with the preferred dimensions (691x978)
            Scene scene = new Scene(root, 691, 978);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setTitle("Menu - POOH");
            // Get the primary screen's bounds
            Screen screen = Screen.getPrimary();
            double screenWidth = screen.getVisualBounds().getWidth();
            double screenHeight = screen.getVisualBounds().getHeight();

            // Calculate the X and Y coordinates for centering the stage
            double stageX = (screenWidth - 691) / 2; // Adjust 691 according to the window width
            double stageY = (screenHeight - 978) / 2; // Adjust 978 according to the window height

            // Set the scene dimensions and position to fit the screen and center the window
            stage.setScene(scene);
            stage.setWidth(691);
            stage.setHeight(978);
            stage.setX(stageX);
            stage.setY(stageY);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}