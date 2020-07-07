package org.example;

import org.example.data.People;
import org.example.data.PersonSequencer;
import org.example.data.TodoItems;
import org.example.data.TodoSequencer;
import org.example.model.Person;
import org.example.model.Todo;
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
    public void personSequencerTest(){
        Person person = new Person(11, "ana", "all");
        PersonSequencer p = new PersonSequencer(person.getPersonId());
        assertEquals(11, PersonSequencer.getPersonId());
        assertEquals(12, PersonSequencer.getNextPersonId());
        PersonSequencer.reset();
        assertEquals(0, PersonSequencer.getPersonId());

    }

    @Test
    public void todoSequencerTest(){
        Todo todo = new Todo(11, "ana");
        TodoSequencer t = new TodoSequencer(todo.getTodoId());
        assertEquals(11, TodoSequencer.getTodoId());
        assertEquals(12, TodoSequencer.getNextTodoId());
        TodoSequencer.reset();
        assertEquals(0, TodoSequencer.getTodoId());
    }

    @Test
    public void peopleTest(){
        People.newPerson("hala", "ali");
        People.newPerson("ana", "ana");
        assertEquals(2, People.size());
        Person p1 = People.findById(2);
        Person p2 = People.findById(1);
        assertNotEquals(p1, p2);
        Person[] persons = People.findAll();
        assertEquals(persons.length, People.size());
        persons = People.incressPersonSize(persons);
        assertEquals(3, persons.length);
        assertEquals(null, People.findById(50));
        People.clear();
        assertEquals(0, People.size());
    }

    @Test
    public void todoItemsTest(){
        TodoItems.newTodo("hala");
        TodoItems.newTodo("ana");
        assertEquals(2, TodoItems.size());

        //findById
        Todo t1 = TodoItems.findById(2);
        Todo t2 = TodoItems.findById(1);
        assertNotEquals(t1, t2);

        //findAll
        Todo[] todos = TodoItems.findAll();
        assertEquals(todos.length, TodoItems.size());

        //incressTodoSize
        todos = TodoItems.incressTodoSize(todos);
        assertEquals(3, todos.length);
        assertEquals(null, TodoItems.findById(50));

        //findByAssignee
        todos = TodoItems.findByAssignee(null);
        assertEquals(2, todos.length);

        //findUnassignedTodoItems
        todos = TodoItems.findUnassignedTodoItems();
        assertEquals(2, todos.length);

        //remove object
        TodoItems.removeObject(2);
        assertEquals(1, TodoItems.size());

        //Clear
        TodoItems.clear();
        assertEquals(0, TodoItems.size());

        //findByAssignee(int personId)
        Person pp1 = People.newPerson("ghada", "alnajjar");
        Todo tt1 = TodoItems.newTodo("ana");
        Todo tt2 = TodoItems.newTodo("all");
        tt1.setAssignee(pp1);
        tt1.setDone(true);
        tt2.setAssignee(pp1);
        tt2.setDone(false);
        Todo[] todos1 = TodoItems.findByAssignee(pp1.getPersonId());
        Todo[] todos2 = {tt1, tt2};
        assertArrayEquals(todos1, todos2);

        //findByDoneStatus
        todos = TodoItems.findByDoneStatus(true);
        assertEquals(1, todos.length);
    }
}