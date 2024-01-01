package com.example.medicare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePageApplication.class.getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 414, 896);
        stage.setTitle("MediCare");
        stage.setScene(scene);
        stage.setResizable(false); ///INFORMA CAMBIAMENTO
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}