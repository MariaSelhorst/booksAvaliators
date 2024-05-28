package com.bookavaliator;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;


public class AddBookSceneController {
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = AddBookSceneController.class
                .getResource("add-book-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    private Button btAddImg;

    @FXML
    private Button btNewBook;

    @FXML
    private Button btSearch;

    @FXML
    private TextField tbSearch;

    @FXML
    private TextField tbBookName;

    @FXML
    private TextField tbBookAuthor;

    @FXML
    private ImageView imBook;

    @FXML
    protected void addBookImg(ActionEvent e) {
        Alert alert = new Alert(
                AlertType.NONE,
                "imagem adicionada",
                ButtonType.OK);
        alert.showAndWait();
        return;//modificar
    }

    @FXML
    protected void addNewBook(ActionEvent e) {
        Alert alert = new Alert(
                AlertType.NONE,
                "livro adicionado",
                ButtonType.OK);
        alert.showAndWait();
        return;//modificar
    }

    @FXML
    protected void searchBook(ActionEvent e) {
        Alert alert = new Alert(
                AlertType.NONE,
                "pesquisado",
                ButtonType.OK);
        alert.showAndWait();
        return;//modificar
    }
}
