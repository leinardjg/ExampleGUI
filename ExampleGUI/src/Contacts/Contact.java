package Contacts;

public class Contact {

    // instance variables
    private String name;
    private String email;

    // constructor
    public Contact(String name, String email){
        this.setName(name);
        this.setEmail(email);
    }

    // setters
    void setName(String newName) {
        this.name = newName;
    }

    void setEmail(String newEmail) {
        this.email = newEmail;
    }

    // getters
    String getName() {
        return this.name;
    }

    String getEmail() {
        return this.email;
    }
}
