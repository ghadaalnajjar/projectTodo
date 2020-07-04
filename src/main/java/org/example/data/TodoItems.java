package org.example.data;

import org.example.model.Person;
import org.example.model.Todo;

import java.util.Arrays;

public class TodoItems {
    private static Todo[] todos = new Todo[0];

    public static void main(String[] args) {
    }

    public static int size() {
        return todos.length;
    }

    public static Todo[] findAll(Todo[] todo) {
        for (int i = 0; i < size(); i++) {
            if (todos[i].equals(todo))
                return todo;
        }
        return null;
    }
    public static Todo findById(int todoId){
        for (int i = 0; i < size(); i++){
            if (todos[i].getTodoId() == todoId)
                return todos[i];
        }
        return null;
    }

    public static Todo newTodo (String des){
        Todo todo= new Todo(TodoSequencer.nextTodoId(getMaxTodoId(todos)), des);
        todos = incressTodoSize(todos);
        todos[size()-1] = todo;
        return todos[size()-1];
    }

    public static int getMaxTodoId(Todo[] todo){
        if(todo.length == 0)
            return 1;
        else{
            int max = 0;
            for (int i = 0; i < todo.length; i++){
                if(max < todos[i].getTodoId())
                    max = todos[i].getTodoId();
            }
            return max;
        }
    }

    public static Todo[] incressTodoSize(Todo[] todo) {
        return Arrays.copyOf(todo, size() + 1);
    }

    public static void clear(){
        todos = new Todo[0];
    }

    public static Todo[] findByDoneStatus(boolean doneStatus){
        Todo[] t = new Todo[0];
        for (int i = 0; i < size(); i++){
            if (todos[i].getDone() == doneStatus) {
                Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
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
            if(todos[i].getAssignee().equals(assignee)){
                t = Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
    }

    public static Todo[] findUnassignedTodoItems(){
        Todo[] t = new Todo[0];
        for (int i = 0; i < size(); i++){
            if(todos[i].getAssignee().equals(null)){
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
