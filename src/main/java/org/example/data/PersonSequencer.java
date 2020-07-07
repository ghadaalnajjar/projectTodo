package org.example.data;

public class PersonSequencer {

    private static int personId;

    public static int getNextPersonId(){
       personId ++;
       return personId;
    }
    public static void reset(){
        personId =  0;
    }
}