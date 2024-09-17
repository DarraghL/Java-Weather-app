module com.example.javafxshell {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.javafxshell to javafx.fxml;
    exports com.example.javafxshell;
}
