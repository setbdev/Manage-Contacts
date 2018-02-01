package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void addNewContact(Contact contact) {

        if (doesExist(contact)) {
            System.out.println("Contact " + contact.getName() + " already exists");
        } else {
            contacts.add(contact);
        }

    }

    public void printAllContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " " + contact.getNumber());
        }
    }

    public void updateContact(String currentContactName, String newContactName) {
        Contact contact = doesExist(currentContactName);

        if (contact != null) {
            int position = contactPosition(contact);
            contact.setName(newContactName);
            System.out.println("Contact " + (position + 1) + " has been modified");
        } else {
            System.out.println("Contact " + currentContactName + " not found");
        }
    }

    public void removeContact(String currentContactName) {
        Contact contact = doesExist(currentContactName);

        if (contact != null) {
            contacts.remove(contact);
        } else {
            System.out.println("Contact " + currentContactName + " not found");
        }
    }

    public void searchForContact(String contactToSearch) {
        Contact contact = doesExist(contactToSearch);

        if (contact != null) {
            System.out.println(contactToSearch + " found in your contact list");
        } else {
            System.out.println("Contact " + contactToSearch + " not found");
        }
    }

    private Contact doesExist(String contactName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contactName.equals(contacts.get(i).getName())) {
                return contacts.get(i);
            }
        }
        return null;
    }

    private boolean doesExist(Contact contact) {
        if (contacts.contains(contact)) {
            return true;
        }

        return false;
    }

    private int contactPosition(Contact contact) {
        return contacts.indexOf(contact);
    }


}
