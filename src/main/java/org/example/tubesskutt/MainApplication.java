package org.example.tubesskutt;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent splashRoot = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
        Scene splashScene = new Scene(splashRoot);
        stage.setTitle("POOH");
        stage.setScene(splashScene);
        stage.show();

        // Tunda perubahan halaman selama 5 detik
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(e -> {
            try {
                // Beralih ke Menu.fxml
                Parent menuRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Scene menuScene = new Scene(menuRoot, 691.0, 978.0);
                stage.setTitle("Menu - POOH");
                stage.setScene(menuScene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        delay.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}