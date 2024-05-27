package com.bookavaliator;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
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

    @FXML
    protected void toAvaPag(ActionEvent e) {
        Stage crrStage = (Stage) btAvaPag
            .getScene().getWindow();
        
        crrStage.close();

        try {
            Stage stage = new Stage();
            Scene scene = BookPageSceneController.Create();
            stage.setScene(scene);
            stage.show();

        } 
        catch (Exception ex) {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "Erro ao carregar a página",
                    ButtonType.OK);

            alert.showAndWait();
            ex.printStackTrace();
            return;
        }
    }

}
