package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElevadorTest {

    private Elevador elevador;

    @BeforeEach
    public void setUp() {
        elevador = new Elevador();
    }

    @Test
    public void testCreatePerson() {
        Person p = new Person(1);
        elevador.addPerson(p);
        Assertions.assertEquals(1, elevador.getPeople().size());
        Assertions.assertEquals(p, elevador.getPeople().get(0));
    }

    @Test
    public void testElevatorOperation() {
        // Create three people on different floors
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        //Person p3 = new Person(3);

        // Add people to their respective floors and press button
        elevador.addPerson(p2);
        //elevador.addPerson(p3);
        elevador.addPerson(p1);

        // Elevator should go to floor 2 first to pick up p2
        elevador.operate();
        Assertions.assertEquals(2, elevador.getClass());

        // Assert p2 is in elevator and p1 and p3 are not
        Assertions.assertEquals(1, elevador.getPeople().size());
        Assertions.assertEquals(p2, elevador.getPeople().get(0));

        // Elevator should go to floor 3 next to pick up p3
        elevador.operate();
        Assertions.assertEquals(3, elevador.getClass());

        // Assert p2 and p3 are in elevator and p1 is not
        Assertions.assertEquals(2, elevador.getPeople().size());
        Assertions.assertTrue(elevador.getPeople().contains(p2));
        //Assertions.assertTrue(elevador.getPeople().contains(p3));

        // Elevator should go to floor 1 next to drop off p2 and p3
        elevador.operate();
        Assertions.assertEquals(1, elevador.getClass());

        // Assert elevator is empty and both people have reached their destination
        Assertions.assertEquals(0, elevador.getPeople().size());
    }
}

