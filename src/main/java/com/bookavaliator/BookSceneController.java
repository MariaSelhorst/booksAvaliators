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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;

public class BookSceneController {

    private String bookId;

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public static Scene CreateScene(String bookId) throws Exception {
        URL sceneUrl = BookSceneController.class.getResource("book-page-scene.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();

        BookSceneController controller = loader.getController();
        controller.setBookId(bookId);

        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    private Button btAddAva;

    @FXML
    private Label lbBookTitle;

    @FXML
    private Label lbBookAuthor;

    @FXML
    private ListView<String> lvComments;

    @FXML
    private ScrollBar scComments;

    @FXML
    private ImageView ivBook;

    @FXML
    protected void toRatingPag(ActionEvent e) {
        Stage crrStage = (Stage) btAddAva
                .getScene().getWindow();
        crrStage.close();

        try {
            Stage stage = new Stage();
            Scene scene = RatingSceneController.CreateScene(bookId);
            stage.setScene(scene);
            stage.show();

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
}