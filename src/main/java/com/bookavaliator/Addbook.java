package com.bookavaliator;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Addbook {
    public static Scene CreateScene() throws Exception
    {
        URL sceneUrl = MainPageController.class
            .getResource("add-book-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected
}

