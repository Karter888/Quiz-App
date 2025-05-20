import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class QuizAppTest {

    @Test
    public void testFXMLLoad() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/resources/group/assign1/quizapp/quiz_layout.fxml"));
            Parent root = loader.load();
            assertNotNull(root); // Ensure the FXML file loads successfully
        } catch (IOException e) {
            fail("FXML file not loaded correctly");
        }
    }
}