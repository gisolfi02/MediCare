module com.example.medicare {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;
    requires org.testng;
    requires javafx.web;

    opens com.example.medicare to javafx.fxml;
    exports com.example.medicare;
    exports test;
}