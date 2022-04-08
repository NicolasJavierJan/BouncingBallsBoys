module com.example.bouncingballsboys {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bouncingballsboys to javafx.fxml;
    exports com.example.bouncingballsboys;
}