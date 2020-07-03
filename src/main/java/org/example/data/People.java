package org.example.data;

import org.example.model.Person;

import java.util.Arrays;

public class People {
    private static Person[] persons = new Person[0];

    public static void main(String[] args) {
    }

    public static int size() {
        return persons.length;
    }

    public static Person[] findAll(Person[] person) {
        for (int i = 0; i < size(); i++) {
            if (persons[i].equals(person))
                return person;
        }
        return null;
    }
    public static Person findById(int personId){
        for (int i = 0; i < size(); i++){
            if (persons[i].getPersonId() == personId)
                return persons[i];
        }
        return null;
    }
    public static Person newPerson (String fname, String lname){
        Person person;
        if(size() == 0) {
            person = new Person(1, fname, lname);
            incressPersonSize();
            persons[size()] = person;
            return persons[size()];
        }
        else {
            person = new Person(PersonSequencer.nextPersonId(persons[size() - 1].getPersonId()), fname, lname);
            incressPersonSize();
            persons[size() - 1] = person;
            return persons[size() - 1];
        }
    }
    public static Person[] incressPersonSize() {
        if (size() == 0)
            return Arrays.copyOf(persons, 1);
        else
            return Arrays.copyOf(persons, size() + 1);
    }
    public static void clear(){
        persons = new Person[0];
    }
}

