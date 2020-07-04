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

    public static int getMaxPersonId(Person[] person){
        if(person.length == 0)
            return 1;
        else{
            int max = 0;
            for (int i = 0; i < person.length; i++){
                if(max < person[i].getPersonId())
                    max = person[i].getPersonId();
            }
            return max;
        }
    }

    public static Person newPerson (String fname, String lname){
        Person person = new Person(PersonSequencer.nextPersonId(getMaxPersonId(persons)) , fname, lname);
        persons = incressPersonSize(persons);
        persons[size()-1] = person;
        return persons[size()-1];
    }

    public static Person[] incressPersonSize(Person[] person) {
        return Arrays.copyOf(person, size() + 1);
    }


    public static void clear(){
        persons = new Person[0];
    }
}

