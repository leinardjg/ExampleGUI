package Pomodoro;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

public class PomodoroGUI {

    private ScrollPane scrollPane = new ScrollPane();

    public PomodoroGUI() {
        // <build Pomodoro GUI here>
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(800, 600);
        Label label = new Label("Pomodoro timer lives here!");
        stackPane.getChildren().add(label);
        this.scrollPane.setContent(stackPane);
    }

    public ScrollPane getPomodoroGUIContent() {
        return this.scrollPane;
    }
}
