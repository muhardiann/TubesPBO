module org.example.tubesskutt {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tubesskutt to javafx.fxml;
    exports org.example.tubesskutt;
}