package org.example.data;

public class TodoSequencer {
    private static int todoId;

    public TodoSequencer(int todoId) {
        this.todoId = todoId;
    }
    public static int getTodoId() {
        return todoId;
    }
    public static int getNextTodoId(){
        return todoId = todoId + 1;
    }
    public static void reset(){
        todoId =  0;
    }
}
