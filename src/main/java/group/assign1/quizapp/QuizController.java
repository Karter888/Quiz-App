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
    @FXML
    private Label questionLabel;
    @FXML
    private RadioButton option1;
    @FXML
    private RadioButton option2;
    @FXML
    private RadioButton option3;
    @FXML
    private RadioButton option4;
    @FXML
    private Button submitButton;
    @FXML
    private Button nextButton;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label feedBackLabel;
    @FXML
    private ToggleGroup answerGroup;

    //Data fields
    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;
    private RadioButton[] optionButtons; //

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //score all options buttons in an array
        optionButtons = new RadioButton[]{option1, option2, option3, option4};

        //adds listener to enable submit button when an option is selected
        answerGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue == null);
        });

        loadQuestions();

        displayQuestion(currentQuestionIndex);

        updateScoreDisplay();

    }

    /**
     * well class loads sampled questions for the quiz
     */

    private void loadQuestions() {

        //Need to look up how implement API's and apply them here.

    }

    /**
     * displays question at given index
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

    /**
     * Handles Submission of Answers
     */
    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {

        //Gets selected radio button
        RadioButton selectedButton = (RadioButton) answerGroup.getSelectedToggle();

        //If nothing is selected then
        //if (selectedOption == null) return;

        int selectedIndex = -1;
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i] == selectedOption) {
                selectedIdex = i;
                break;
            }
        }

        //Gets current question
        Question currentQuestion = questions.get(currentQuestionIndex);

        //compares selected index with correct index
        boolean isCorrect = (selectedIndex == currentQuestion.getCorrectAnswerIndex());

        //updates the score when answer is right
        if (isCorrect) {
            score++;
            updateScoreDisplay();
            feedBackLabel.setText("Correct");
            feedBackLabel.setTextFill(Color.GREEN);
        } else {
            feedBackLabel.setText("Incorrect. The Answer is: " + currentQuestion.getOptions()[currentQuestion.getCorrectAnswerIndex()]);
            feedBackLabel.setTextFill(Color.RED);
        }

        //Highlights the right and wrong answers
        for (int i = 0; i < optionButtons.length; i++) {
            if (i == currentQuestion.getCorrectAnswerIndex()) {
                optionButton[i].getStyleClass().add("correct-answer");
            } else if (i == selectedIndex && !isCorrect) {
                optionButtons[i].getStyleClass().add("wrong-answer");
            }
        }

        //Disable the radio buttons to prevent changing the answer
        for (RadioButton button : optionButtons) {
            button.setDisable(true);
        }

        //Disable submit button and enables next button
        submitButton.setDisable(true);
        nextButton.setDisable(false);
    }

    /**
     * Moving to the NExt Question
     */
    @FXML
    private void handleNextButton() {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), questionLabel);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setCycleCount(1);

        //sets action
        rotateTransition.setOnFinished(event -> {
            currentQuestionIndex++;
            displayQuestion(currentQuestionIndex);
        });
        rotateTransition.play();
    }

    /**
     * update the score Display
     */
    private void updateScoreDisplay() {
        scoreLabel.setText("Score:" + score + "/" + questions.size());
    }

    /**
     * shows the final score for all answers to questions
     */
    private void showFinalScore() {
        questionLabel.setText("Quiz Completed!");
        for (RadioButton button : optionButtons) {
            button.setVisible(false);
        }

        //Display the final score
        feedBackLabel.setText("Your final score : " + score + "out of" + question.size());
        feedBackLabel.setTextFill(Color.BLUE);

        //Disables Both Buttons
        submitButton.setDisable(true);
        nextButton.setDisable(true);
    }
}