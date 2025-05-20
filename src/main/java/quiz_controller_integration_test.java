import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class QuizControllerTest extends ApplicationTest {

    private Label questionLabel;
    private Button submitButton;
    private RadioButton option1;

    @Override
    public void start(Stage stage) { 
        // Create mock JavaFX elements
        questionLabel = new Label("What is 2 + 2?");
        option1 = new RadioButton("4");
        submitButton = new Button("Submit");

        VBox root = new VBox(questionLabel, option1, submitButton);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }

    @Test
    public void testSubmitButton() {
        clickOn(option1); // Click the option
        clickOn(submitButton); // Click the submit button

        String feedback = "Correct!"; // Example feedback after submission
        assertEquals(feedback, questionLabel.getText()); // Verify label text changes
    }
}