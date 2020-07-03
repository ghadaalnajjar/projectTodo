package org.example.data;

import org.example.model.Todo;

public class TodoSequencer {
    private static int todoId(Todo todo){
        return todo.getTodoId();
    }
    public static int nextTodoId(int todoId){
        return todoId + 1;
    }
    public static int reset(int todoId){
        return 0;
    }
}
