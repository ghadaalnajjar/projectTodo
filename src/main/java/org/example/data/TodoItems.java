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
        Todo todo= new Todo(TodoSequencer.nextTodoId(todos[size()-1].getTodoId()), des);
        incressTodoSize();
        todos[size()-1] = todo;
        return todos[size()-1];
    }
    public static Todo[] incressTodoSize() {
        return Arrays.copyOf(todos, size() + 1);
    }
    public static void clear(){
        todos = new Todo[0];
    }
    public Todo[] findByDoneStatus(boolean doneStatus){
        Todo[] t = new Todo[0];
        for (int i = 0; i < size(); i++){
            if (todos[i].getDone() == doneStatus) {
                Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
    }
    public Todo[] findByAssignee(int personId){
        Todo[] t = new Todo[0];
        Person[] p = new Person[0];
        for (int i = 0; i < size(); i++){
            Arrays.copyOf(p, p.length + 1);
            p[p.length-1] = todos[i].getAssignee();
            if(p[p.length-1].getPersonId() == personId){
                Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
    }
    public Todo[] findByAssignee(Person assignee){
        Todo[] t = new Todo[0];
        for (int i = 0; i < size(); i++){
            if(todos[i].getAssignee().equals(assignee)){
                Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
    }
    public Todo[] findUnassignedTodoItems(){
        Todo[] t = new Todo[0];
        for (int i = 0; i < size(); i++){
            if(todos[i].getAssignee().equals(null)){
                Arrays.copyOf(t, t.length + 1);
                t[t.length-1] = todos[i];
            }
        }
        return t;
    }
    public void removeObject(Todo todo){
        for (int i = 0; i < size(); i++){
            if (todo.getTodoId() == todos[i].getTodoId()){
                todos[i] = null;
            }
        }
    }

}
