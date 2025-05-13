module group.assign1.quizapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens group.assign1.quizapp to javafx.fxml;
    exports group.assign1.quizapp;
}