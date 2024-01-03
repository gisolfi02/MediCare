package com.example.medicare;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
public class HomePageController{
    @FXML
    private Button homeButton;

    @FXML
    private Button profiloButton;
    public void initialize() {
        // Aggiungi i tooltip programmaticamente se necessario
        Tooltip homeTooltip = new Tooltip("Clicca per tornare alla Home");
        Tooltip.install(homeButton, homeTooltip);

        Tooltip profiloTooltip = new Tooltip("Visualizza il tuo profilo");
        Tooltip.install(profiloButton, profiloTooltip);
    }
}