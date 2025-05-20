import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuizLogicTest {

    @Test
    public void testScoreUpdate() {
        QuizLogic quizLogic = new QuizLogic();
        quizLogic.addQuestion(new Question("What is 2 + 2?", "4", List.of("4", "3", "5", "1")));
        
        quizLogic.answerQuestion("4");
        assertEquals(1, quizLogic.getScore()); // Score should be 1 after a correct answer
    }

    @Test
    public void testInvalidAnswer() {
        QuizLogic quizLogic = new QuizLogic();
        quizLogic.addQuestion(new Question("What is 2 + 2?", "4", List.of("4", "3", "5", "1")));

        quizLogic.answerQuestion("3");
        assertEquals(0, quizLogic.getScore()); // Score stays 0 after a wrong answer
    }
}