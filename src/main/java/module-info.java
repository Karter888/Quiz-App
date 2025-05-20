module group.assign1.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.net.http;
    requires com.google.gson;
    requires org.junit.jupiter.api;


    opens group.assign1.quizapp to javafx.fxml;
    exports group.assign1.quizapp;
}