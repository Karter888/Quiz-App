package group.assign1.quizapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApp.class.getResource("quiz_layout.fxml"));

        // Load root node
        javafx.scene.Parent root = fxmlLoader.load();

        // Create scene
        Scene scene = new Scene(root, 320, 240);

        // Add stylesheet
        scene.getStylesheets().add(getClass().getResource("/group/assign1/quizapp/styles.css").toExternalForm());

        stage.setTitle("Quiz It");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}