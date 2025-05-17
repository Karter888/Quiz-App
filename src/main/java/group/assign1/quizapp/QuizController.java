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

public class QuizController implements Initializable {

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

    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;
    private RadioButton[] optionButtons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
