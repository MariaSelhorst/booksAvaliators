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
        URL sceneUrl = MainSceneController.class.getResource("main-page-scene.fxml");
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
    private VBox bookContainer;

    @FXML
    protected void toAvaPag(ActionEvent e, String bookId) {
        System.out.println("Book ID: " + bookId);
        
        try {
            Stage stage = new Stage();
            Scene scene = BookSceneController.CreateScene(bookId);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR, "Erro ao carregar a página", ButtonType.OK);
            alert.showAndWait();
            ex.printStackTrace();
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
            Alert alert = new Alert(AlertType.ERROR, "Erro ao carregar a página", ButtonType.OK);
            alert.showAndWait();
            ex.printStackTrace();
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
        if (books.isEmpty()) {
            bookPane.setVisible(false);
            bookPane.setManaged(false);
        } else {
            bookPane.setVisible(true);
            bookPane.setManaged(true);

            bookContainer.getChildren().clear();

            for (Map<String, String> book : books) {
                String title = book.get("title");
                String author = book.get("author");
                String bookId = book.get("id");

                VBox bookBox = new VBox();
                bookBox.setSpacing(5);
                bookBox.setStyle("-fx-background-color: white; -fx-padding: 10; -fx-border-color: gray; -fx-border-width: 1;");
                bookBox.setPrefSize(300, 100);

                Label titleLabel = new Label("Title: " + title);
                titleLabel.setWrapText(true);
                titleLabel.setPrefWidth(280);

                Label authorLabel = new Label("Author: " + author);

                Button reviewButton = new Button("Ver Avaliações");
                reviewButton.setOnAction(event -> toAvaPag(event, bookId));

                bookBox.getChildren().addAll(titleLabel, authorLabel, reviewButton);
                bookContainer.getChildren().add(bookBox);
            }
        }
    }
}
