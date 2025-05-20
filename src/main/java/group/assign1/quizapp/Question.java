package group.assign1.quizapp;

public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex; // 0-based index of the correct answer in the options array

    /**
     * Constructs a question with the specified text, options, and correct answer index
     */
    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}