module com.example.javafxshell {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxshell to javafx.fxml;
    exports com.example.javafxshell;
}