package org.example.data;

public class TodoSequencer {
    private static int todoId;

    public static int getNextTodoId(){
        todoId ++;
        return todoId;
    }
    public static void reset(){
        todoId =  0;
    }
}
