package group.assign1.quizapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/group/assign1/quizapp/quiz_layout.fxml"));
            Parent root = loader.load();

            // Create the scene
            Scene scene = new Scene(root);

            // Add CSS styling
            scene.getStylesheets().add(getClass().getResource("/group/assign1/quizapp/style.css").toExternalForm());

            // Configure and show the stage
            primaryStage.setTitle("Quiz It!");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(500);
            primaryStage.setMinHeight(400);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}