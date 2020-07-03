package org.example.model;

public class Todo {
    //field/
    private final int todoId;
    private String description;
    private Boolean done;
    Person assignee = new Person(123,"ana", "all");

    // The constructor method
    public Todo (int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    //Getters & Setters
    public int getTodoId() {
        return todoId;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done){
        this.done = done;
    }

    public Person getAssignee() {
        return assignee;
    }
    public void setAssignee (Person assignee) {
        this.assignee = assignee;
    }
}
