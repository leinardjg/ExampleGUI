package Contacts;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ContactGUI {

    // instance variables
    private ScrollPane root = new ScrollPane();
    private ContactManager contactManager = new ContactManager();
    private StackPane contactsMainScreen = new StackPane();

    // build component (Contacts in this case) GUI
    public ContactGUI() {
        VBox vBox = new VBox();

        HBox hBox = new HBox();
        Button viewContactsButton = new Button("View Contacts");
        Button createContactButton = new Button("Create a Contact");
        viewContactsButton.setOnAction(__ -> this.displayContacts());
        createContactButton.setOnAction(__ -> this.createContact());
        hBox.getChildren().addAll(viewContactsButton, createContactButton);

        contactsMainScreen.setPrefSize(800, 600);
        contactsMainScreen.setStyle("-fx-background-color: #DCDCDC");
        Insets padding = new Insets(100, 100, 100, 100);
        contactsMainScreen.setPadding(padding);
        vBox.getChildren().addAll(hBox, contactsMainScreen);

        this.root.setContent(vBox);
    }

    public ScrollPane getContactGUIContent() {
        return this.root;
    }

    public void displayContacts() {
        this.contactsMainScreen.getChildren().clear();
        VBox vBox = new VBox();
        if (!contactManager.getContactList().isEmpty()) {
            for (Contact contact : contactManager.getContactList()) {
                Label displayContact = new Label(contact.getName() + "'s e-mail is " + contact.getEmail());
                vBox.getChildren().add(displayContact);
            }
            this.contactsMainScreen.getChildren().add(vBox);
        } else {
            Label label = new Label("Your contact list is empty!");
            this.contactsMainScreen.getChildren().clear();
            this.contactsMainScreen.getChildren().add(label);
        }
    }

    public void createContact() {
        this.contactsMainScreen.getChildren().clear();

        HBox hBoxName = new HBox();
        HBox hboxEmail = new HBox();
        VBox vBox = new VBox();

        Label namePrompt = new Label("Enter name: ");
        Label emailPrompt = new Label("Enter e-mail: ");
        TextField nameTextField = new TextField();
        TextField emailTextField = new TextField();

        Button createContactButton = new Button("Create contact");
        createContactButton.setOnAction(__ -> {
            contactManager.addContact(nameTextField.getText(), emailTextField.getText());
            nameTextField.clear();
            emailTextField.clear();
        });

        hBoxName.getChildren().addAll(namePrompt, nameTextField);
        hboxEmail.getChildren().addAll(emailPrompt, emailTextField);
        vBox.getChildren().addAll(hBoxName, hboxEmail, createContactButton);
        contactsMainScreen.getChildren().add(vBox);
    }
}
