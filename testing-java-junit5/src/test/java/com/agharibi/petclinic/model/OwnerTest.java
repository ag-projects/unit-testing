package com.agharibi.petclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Alexis", "Ta");
        owner.setCity("Pasadena");
        owner.setTelephone("858-200-9800");

        assertAll("Properties test",
            () -> assertAll("Person properties",
                () -> assertTrue(1L == owner.getId()),
                () -> assertEquals("Alexis", owner.getFirstName(), "First name did not match"),
                () -> assertEquals("Ta", owner.getLastName(), "Last name did not match")
            ),
            () -> assertAll("Owner properties",
                () -> assertEquals("Pasadena", owner.getCity(), "City name did not match"),
                () -> assertEquals("858-200-9800", owner.getTelephone(), "Phone number did not match.")
            )
        );
    }
}
