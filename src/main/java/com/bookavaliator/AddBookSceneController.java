package com.bookavaliator;

import java.net.URL;

import com.bookavaliator.model.Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private Button btNewBook;

    @FXML
    private TextField tbBookName;

    @FXML
    private TextField tbBookAuthor;

    @FXML
    protected void addNewBook(ActionEvent e) {
   
        Book novoLivro = new Book();
        novoLivro.setBookTitle(tbBookName.getText());
        novoLivro.setBookAuthor(tbBookAuthor.getText());

        Addbook newBook = new Addbook();
        newBook.insertBook(novoLivro);

        Alert alert = new Alert(
                    AlertType.INFORMATION,
                    "Livro Adicionado!",
                    ButtonType.OK);

            alert.showAndWait();    
        }
}