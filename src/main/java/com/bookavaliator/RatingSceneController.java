package com.bookavaliator;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RatingSceneController {

    public static Scene CreateScene() throws Exception {

        URL sceneUrl = RatingSceneController.class
                .getResource("rating-page-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    private Button btPublish;

    @FXML
    private TextField tbNota;

    @FXML
    private TextField tbUsername;

    @FXML
    private TextArea taComment;

    @FXML
    protected void addRating(ActionEvent e) {

    }
}