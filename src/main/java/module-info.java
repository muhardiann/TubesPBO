module org.example.tubesskutt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.tubesskutt to javafx.fxml;
    exports org.example.tubesskutt;
}