package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.data.People;
import org.example.data.PersonSequencer;
import org.example.data.TodoItems;
import org.example.data.TodoSequencer;
import org.example.model.Person;
import org.example.model.Todo;
import org.junit.Test;

public class AppTest {


    @Test
    public void personTest(){
        Person person = new Person(1235, "Ghad", "Alnaj");
        person.setFirstName("Ghada");
        person.setLastName("Alnajjar");

        //Assert
        assertEquals(1235, person.getPersonId());
        assertEquals("Ghada", person.getFirstName());
        assertEquals("Alnajjar", person.getLastName());
    }

    @Test
    public void todoTest(){
        Todo todo = new Todo(123, "ana");
        todo.setDescription("ali");
        todo.setDone(true);
        Person person = new Person(345,"maha", "klalid");
        todo.setAssignee(person);

        //Assert
        assertEquals(123, todo.getTodoId());
        assertEquals("ali",todo.getDescription() );
        assertTrue(todo.getDone());
        assertEquals(person, todo.getAssignee());
    }

    @Test
    public void personSequencerTest(){
        Person person = new Person(11, "ana", "all");

        assertEquals(12, PersonSequencer.nextPersonId(person.getPersonId()));
        //assertEquals(0, PersonSequencer.reset(person.getPersonId()));

    }

    @Test
    public void todoSequencerTest(){
        Todo todo = new Todo(11, "ana");
        assertEquals(12, TodoSequencer.nextTodoId(todo.getTodoId()));
        assertEquals(0, TodoSequencer.reset(todo.getTodoId()));

    }

    @Test
    public void peopleTest(){
        People.newPerson("ana", "ali");
        assertEquals(1, People.size());
        People.clear();
        assertEquals(0, People.size());
    }

    @Test
    public void todoItemsTest(){
        TodoItems.newTodo("ana");
        TodoItems.newTodo("alnajjar");
        assertEquals(2, TodoItems.size());
        TodoItems.removeObject(2);
        assertEquals(1, TodoItems.size());
        TodoItems.clear();
        assertEquals(0, TodoItems.size());
    }
}