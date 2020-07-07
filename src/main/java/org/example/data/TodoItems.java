package org.example.data;

import org.example.model.Person;
import org.example.model.Todo;

import java.util.Arrays;

public class TodoItems {
    private static Todo[] todos = new Todo[0];

    public static int size() {
        return todos.length;
    }

    public static Todo[] findAll() {
        return todos;
    }
    public static Todo findById(int todoId){
        for (int i = 0; i < size(); i++){
            if (todos[i].getTodoId() == todoId)
                return todos[i];
        }
        return null;
    }

    public static Todo newTodo (String des){
        Todo todo= new Todo(TodoSequencer.getNextTodoId(), des);
        todos = incressTodoSize(todos);
        todos[size()-1] = todo;
        return todos[size()-1];
    }

    public static Todo[] incressTodoSize(Todo[] todo) {
        return Arrays.copyOf(todo, size() + 1);
    }

    public static void clear(){
        todos = new Todo[0];
    }

    public static Todo[] findByDoneStatus(boolean doneStatus){
        Todo[] statusArray = new Todo[0];
        for (int i = 0; i < size(); i++){
            if (Boolean.TRUE.equals(todos[i].getDone())) {
                statusArray = Arrays.copyOf(statusArray, statusArray.length +1 );
                statusArray[statusArray.length-1] = todos[i];
            }
        }
        return statusArray;
    }

    public static Todo[] findByAssignee(int personId){
        Todo[] t = new Todo[0];
        Person[] p = new Person[0];
        for (int i = 0; i < size(); i++){
            p = Arrays.copyOf(p, p.length + 1);
            p[p.length-1] = todos[i].getAssignee();
            if(p[p.length-1].getPersonId() == personId){
                t = Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
    }

    public static Todo[] findByAssignee(Person assignee){
        Todo[] t = new Todo[0];
        for (int i = 0; i < size(); i++){
            if(todos[i].getAssignee() == assignee){
                t = Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
    }

    public static Todo[] findUnassignedTodoItems(){
        Todo[] t = new Todo[0];
        for (int i = 0; i < size(); i++){
            if(todos[i].getAssignee() == null){
                t = Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
    }

    public static void removeObject(int todoId){
        Todo[] t = new Todo[0];
        for (int i = 0; i < size(); i++){
            if (todoId != todos[i].getTodoId()){
                t = Arrays.copyOf(t, t.length+1);
                t[t.length-1] = todos[i];
            }
        }
        todos = t;
    }

}
