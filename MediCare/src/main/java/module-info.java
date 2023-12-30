module com.example.medicare {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.medicare to javafx.fxml;
    exports com.example.medicare;
}