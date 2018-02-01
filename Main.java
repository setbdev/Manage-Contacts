package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options: Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the ArrayList to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {

            System.out.println("Please enter a choice: \r");
            choice = scanner.nextInt();


            switch (choice) {

                case 0:
                    printInstructions();
                    break;

                case 1:
                    mobilePhone.printAllContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    removeContact();
                    break;

                case 4:
                    updateContact();
                    break;

                case 5:
                    searchForContact();
                    break;

                case 6:
                    quit = true;
                    break;
            }
        }

    }

    private static void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - To see the menu options.");
        System.out.println("\t 1 - To print all contacts to the screen.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To remove a contact.");
        System.out.println("\t 4 - To update a contact.");
        System.out.println("\t 5 - To search for a contact.");
        System.out.println("\t 6 - To quit the application.");
    }


    private static void addNewContact() {
        System.out.print("New contact name: ");
        String contactName = scanner.next();
        System.out.print("New contact number: ");
        String contactNumber = scanner.next();
        mobilePhone.addNewContact(Contact.createContact(contactName, contactNumber));
    }

    private static void removeContact() {
        System.out.print("Contact to remove: ");
        String contactName = scanner.next();
        mobilePhone.removeContact(contactName);
    }

    private static void updateContact() {
        System.out.print("Current contact name: ");
        String currentName = scanner.next();
        System.out.print("New contact name: ");
        String newName = scanner.next();
        mobilePhone.updateContact(currentName, newName);
    }

    private static void searchForContact() {
        System.out.print("Contact to search for: ");
        String contactName = scanner.next();
        mobilePhone.searchForContact(contactName);
    }



}
