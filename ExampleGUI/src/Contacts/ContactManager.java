package Contacts;

import java.util.ArrayList;

public class ContactManager {

    // instance variables
    private ArrayList<Contact> contactList = new ArrayList<>();

    // getters
    // getContactList() : ArrayList<Contact>, returns a COPY of the contactList
    ArrayList<Contact> getContactList() {
        return new ArrayList<>(contactList);
    }

    // getContacts() : ArrayList<Contact>, returns the actual contactList
    private ArrayList<Contact> getContacts() {
        return this.contactList;
    }

    // contact management methods
    void addContact(String newName, String newEmail) {
        this.getContacts().add(new Contact(newName, newEmail));
    }
}
