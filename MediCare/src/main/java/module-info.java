module com.example.medicare {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.medicare to javafx.fxml;
    exports com.example.medicare;
}