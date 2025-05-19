package group.assign1.quizapp;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *  SuperClass that holds the App Attributes and important Methods
 */
public class QuizController implements Initializable {
    // FXML annotated fields that link with the elements in the
    // quiz_layout file
    @FXML private Label questionLablel;
    @FXML private RadioButton option1;
    @FXML private RadioButton option2;
    @FXML private RadioButton option3;
    @FXML private RadioButton option4;
    @FXML private Button submitButton;
    @FXML private Button nextButton;
    @FXML private Label scoreLabel;
    @FXML private Label feedBackLabel;
    @FXML private ToggleGroup answerGroup;

    //Data fields
    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;
    private RadioButton[] optionButtons; //

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //adds listener to enable submit button when an option is selected
        answerGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue == null);
        });

        loadQuestions();

        displayQuestion(currentQuestionIndex);

        updateScoreDisplay();

    }

/**
 *  well class loads sampled questions for the quiz
 */

private void loadQuestions() {

    //Need to look up how implement API's and apply them here.

    }

/**
 *  displays question at given index
 */
private void displayQuestion(int index) {
      if (index < questions.size()) {
        Question currentQuestion = questions.get(index);

        questionsLabel.setText(currectQuestion.getQuestionText());

        String[] options = currentQuestion.getOptions();
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText(options[i]);
            optionButtons[i].setDisable(false);
            optionButtons[i].getStyleClass().remove("wrong-answer");
            optionButtons[i].getStyleClass().remove("correct-answer");
        }

        answerGroup.selectToggle(null); // clears prevous selection

        feedBackLabel.setText(""); //clears feedback

        nextButton.setDisable(true); //turns of the next button till the answer is submitted
      } else {
          showFinalScore(); // shows final score of all questions answered
      }
    }




}