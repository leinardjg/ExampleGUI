package GUI;

import Contacts.ContactGUI;

import Pomodoro.Pomodoro;
import Pomodoro.PomodoroGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    // instance variables
    TabPane tabPane = new TabPane(); // tab-based app needs TabPane

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.generateTabs();
        Scene scene = new Scene(tabPane, 800, 600); // main scene will take tabPane (contains tabs for each component)
        primaryStage.setTitle("T09-4");
        primaryStage.setScene(scene); // primaryStage will take the scene that contains tabPane that contains the tabs
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void generateTabs() {
        // generate contact tab
        ContactGUI contactGUI = new ContactGUI(); // instantiate GUI for Contacts
        // instantiate new Tab that takes (text : String) as tab name and content to display (from ContactGUI.getContactGUIContent)
        Tab contactTab = new Tab("Contacts", contactGUI.getContactGUIContent());
        contactTab.setClosable(false); // no reason tabs should be closable

        PomodoroGUI pomodoroGUI = new PomodoroGUI();
        Tab pomodoroTab = new Tab("Pomodoro", pomodoroGUI.getPomodoroGUIContent());
        pomodoroTab.setClosable(false);

        // <generate other tabs here>
        // ie. for Grades, To-do, Pomodoro, Schedule

        this.tabPane.getTabs().addAll(contactTab, pomodoroTab); // add all the tabs for each component here (only have Contacts for this example)
    }
}
