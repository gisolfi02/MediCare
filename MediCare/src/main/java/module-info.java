module com.example.medicare {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;
    requires org.testng;
    requires javafx.web;

    opens PresentationTier.MediCare to javafx.fxml;
    exports PresentationTier.MediCare;
    exports test;
}