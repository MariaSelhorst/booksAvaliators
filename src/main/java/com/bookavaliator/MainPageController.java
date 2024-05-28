package com.bookavaliator;

import com.bookavaliator.model.Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;
import java.util.Map;

import java.net.URL;


public class MainPageController {

    public static Scene CreateScene() throws Exception
    {
        URL sceneUrl = MainPageController.class
            .getResource("main-page-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected TextField tbSearch;

    @FXML
    protected Button btAvaPag;

    @FXML
    protected Button btSearch;

    @FXML
    protected Label lbNoBooks;

    @FXML
    protected Button btAddBook;

    @FXML
    protected Pane bookPane;

    @FXML
    protected void searchBook(ActionEvent event) throws Exception {
        Authentication auth = Authentification.searchBook(
            tbSearch.getText()
        );
        String query = tbSearch.getText();
        List<Map<String, String>> result = searchBooks(query);

        if (result.isEmpty()) {
            lbNoBooks.setText("Nenhum livro encontrado.");
        } else {
            lbNoBooks.setText("");
            displayBooks(result);
        }
    }

    private List<Map<String, String>> searchBooks(String query) {
        Session session = HibernateUtil
            .getSessionFactory()
            .openSession();
        Query query = session.createQuery("SELECT new map(b.title as title, b.author as author) FROM Book b WHERE lower(b.title) LIKE :query OR lower(b.author) LIKE :query ");
        query.setParameter("query", "%" + query.toLowerCase() + "%");
        List<Map<String, String>> results = query.list();
        session.close();
        return results;

    }

    private void displayBooks(List<Map<String, String>> books) {
        bookPane.getChildren().clear();
        for (Map<String, String> book : books) {
            Label label = new Label(book.get("title") + " - " + book.get("author"));
            bookPane.getChildren().add(label);
        }
    }

}

