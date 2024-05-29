package com.bookavaliator;

import java.net.URL;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainSceneController {

    public static Scene CreateScene() throws Exception {
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
    private Label lbNoBooks;

    @FXML
    private Pane bookPane;

    @FXML
    protected void toAvaPag(ActionEvent e) {
        try {
            Stage stage = new Stage();
            Scene scene = BookSceneController.CreateScene();
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception ex) {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "Erro ao carregar a página",
                    ButtonType.OK);

            alert.showAndWait();
            ex.printStackTrace();
            return;
        }
    }

    @FXML
    protected void addbookpage(ActionEvent e) {
        try {
            Stage stage = new Stage();
            Scene scene = AddBookSceneController.CreateScene();
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception ex) {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "Erro ao carregar a página",
                    ButtonType.OK);

            alert.showAndWait();
            ex.printStackTrace();
            return;
        }
    }

    @FXML
    protected void searchBook(ActionEvent e) {
        BookSearcher searcher = new BookSearcher();
        List<Map<String, String>> result = searcher.searchBooks(tbSearch.getText());
        

        if (result.isEmpty()) {
            lbNoBooks.setText("Nenhum livro encontrado.");
        } else {
            lbNoBooks.setText("");
            displayBooks(result);
        }
    }

    private void displayBooks(List<Map<String, String>> books) {

        double requiredHeight = books.size() * 50; 
        
        bookPane.setPrefHeight(requiredHeight);
    
        if (books.isEmpty()) {

            bookPane.getChildren().clear();
            bookPane.setVisible(false);

        } else {
            bookPane.setVisible(true);
        
            bookPane.getChildren().clear();

        for (Map<String, String> book : books) {
            String title = book.get("title");
            String author = book.get("author");
    
            // Debugging
            System.out.println("Displaying book: " + title + " - " + author);
    
            VBox bookBox = new VBox();
            bookBox.setSpacing(5); 
    
            Label titleLabel = new Label("Title: " + title);
            Label authorLabel = new Label("Author: " + author);
    
            bookBox.getChildren().addAll(titleLabel, authorLabel);
            bookPane.getChildren().add(bookBox);
        }
    }
}
}
