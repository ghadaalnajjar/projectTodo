package org.example.data;

import org.example.model.Person;

public class PersonSequencer{
    private static int personId(Person person){
        return person.getPersonId();
    }

    public static int nextPersonId(int personId){
        return personId + 1;
    }

    public static void reset(int personId){
        personId =  0;
    }
}
