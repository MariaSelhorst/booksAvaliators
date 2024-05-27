package com.bookavaliator;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainSceneController {
    public static Scene Create() throws Exception {
        URL sceneUrl = MainSceneController.class
            .getResource("main-page-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    private Button btAvaPag;

    @FXML
    private Button btAddBook;

    @FXML
    private Button btSearch;

    @FXML
    private TextField tbSearch;

    
}
