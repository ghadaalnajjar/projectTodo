package org.example.model;

public class Person {
    //field
    private final int personId;
    private String firstName;
    private String lastName;

    // The constructor method
    public Person(int personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //  Getters and Setters
    public int getPersonId() {
        return personId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }
}

