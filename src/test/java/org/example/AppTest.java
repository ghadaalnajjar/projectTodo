package org.example;

import org.example.data.People;
import org.example.data.PersonSequencer;
import org.example.data.TodoItems;
import org.example.data.TodoSequencer;
import org.example.model.Person;
import org.example.model.Todo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void testPersonNextId(){
        int oldid = PersonSequencer.getNextPersonId();

        int newid = PersonSequencer.getNextPersonId();

        assertEquals(oldid + 1, newid);
    }

    @Test
    public void testPersonRest(){
        int oldid = PersonSequencer.getNextPersonId();

        PersonSequencer.reset();

        int newid = PersonSequencer.getNextPersonId();

        assertNotEquals(oldid + 1 , newid);
    }


    @Test
    public void testTodoNextId() {
        int oldId = TodoSequencer.getNextTodoId();

        int newId = TodoSequencer.getNextTodoId();

        assertEquals(oldId + 1, newId);
    }

    @Test
    public void testTodoRest(){
        int oldid = TodoSequencer.getNextTodoId();

        TodoSequencer.reset();

        int newid = TodoSequencer.getNextTodoId();

        assertNotEquals(oldid + 1 , newid);
    }

    People testPeople;
    TodoItems testTodo;

    @Before
    public void doBefore() {
        testPeople = new People();
        People.clear();
        testPeople.newPerson("ana1", "all1");
        testPeople.newPerson("ana2", "all2");

        testTodo = new TodoItems();
        TodoItems.clear();
        testTodo.newTodo("ana");
        testTodo.newTodo("all");
        testTodo.findAll()[0].setDone(true);
        testTodo.findAll()[1].setDone(false);
        testTodo.findAll()[0].setAssignee(testPeople.findById(1));
        testTodo.findAll()[1].setAssignee(testPeople.findById(1));
    }

    @Test
    public void testPeople(){
        People.newPerson("ana", "all");

        assertEquals(1, testPeople.findAll()[0].getPersonId());
        assertEquals("ana1", testPeople.findAll()[0].getFirstName());
        assertEquals("all1", testPeople.findAll()[0].getLastName());

        assertEquals(2, testPeople.findAll()[1].getPersonId());
        assertEquals("ana2", testPeople.findAll()[1].getFirstName());
        assertEquals("all2", testPeople.findAll()[1].getLastName());

    }

    @Test
    public void findByPersonIdFalse() {
        Person foundId = testPeople.findById(3);

        assertNull(foundId);
    }


    @Test
    public void testTodo(){
        TodoItems.newTodo("ana");

        assertEquals("ana", testTodo.findAll()[0].getDescription());
        assertEquals(1, testTodo.findAll()[0].getTodoId());
        assertTrue(testTodo.findAll()[0].getDone());
        assertNotNull(testTodo.findAll()[0].getAssignee());

        assertEquals("all", testTodo.findAll()[1].getDescription());
        assertEquals(2, testTodo.findAll()[1].getTodoId());
        assertFalse(testTodo.findAll()[1].getDone());
        assertNotNull(testTodo.findAll()[1].getAssignee());
    }

    @Test
    public void findByTodoIdFalse() {
        Person foundId = testPeople.findById(3);

        assertNull(foundId);
    }

    @Test
    public void testRemoveObject(){
        assertEquals(2, testTodo.findAll().length);

        TodoItems.removeObject(testTodo.findAll()[1].getTodoId());

        assertEquals(1, testTodo.findAll().length);
    }
}