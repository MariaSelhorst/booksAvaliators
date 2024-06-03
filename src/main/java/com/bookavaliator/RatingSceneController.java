package com.bookavaliator;

import java.net.URL;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bookavaliator.model.Book;
import com.bookavaliator.model.Review;

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
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class RatingSceneController {

    private String bookId;
    private Review review;

    public static Scene CreateScene(String bookId) throws Exception {
        URL sceneUrl = RatingSceneController.class.getResource("rating-page-scene.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();

        RatingSceneController controller = loader.getController();
        controller.setBookId(bookId);

        Scene scene = new Scene(root);
        return scene;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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
        String userName = tbUsername.getText();
        String nota = tbNota.getText();
        String comment = taComment.getText();

        if (!userName.isEmpty() && !nota.isEmpty() && !comment.isEmpty()) {
            // Obtém o livro correspondente ao ID do livro passado para a cena de avaliação
            Long id = Long.parseLong(bookId);
            Book livro = BookService.getBookById(id);
            
            // Se a revisão ainda não foi criada, crie uma nova
            if (review == null) {
                review = new Review();
            }
            
            // Preencha os detalhes da revisão
            review.setComment(comment);
            review.setRating(Integer.parseInt(nota));
            review.setBook(livro);

            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.persist(review);
                transaction.commit();
                
                Alert alert = new Alert(AlertType.INFORMATION, "Avaliação adicionada com sucesso!", ButtonType.OK);
                alert.showAndWait();
            } catch (Exception ex) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                
                Alert alert = new Alert(AlertType.ERROR, "Erro ao adicionar avaliação.", ButtonType.OK);
                alert.showAndWait();
                ex.printStackTrace();
            } finally {
                entityManager.close();
            }

            // Feche a janela após adicionar a avaliação
            ((Stage) btPublish.getScene().getWindow()).close();
        } else {
            Alert alert = new Alert(AlertType.ERROR, "Por favor, preencha todos os campos.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
