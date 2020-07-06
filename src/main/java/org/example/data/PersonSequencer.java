package org.example.data;


public class PersonSequencer {

    private static int personId;

    public PersonSequencer(int personId) {
        this.personId = personId;
    }
    public static int getPersonId() {
        return personId;
    }
    public static int getNextPersonId(){
        return personId = personId + 1;
    }
    public static void reset(){
        personId =  0;
    }
}