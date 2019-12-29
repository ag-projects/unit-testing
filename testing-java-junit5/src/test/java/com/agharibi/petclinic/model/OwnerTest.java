package com.agharibi.petclinic.model;

import com.agharibi.petclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

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

        // hamcrest assertion
        assertThat(owner.getCity(), is("Pasadena"));
    }

    @DisplayName("Value Source Test - ")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments} ")
    @ValueSource(strings = {"spring", "framework", "tests"})
    void valueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Value Source Test - ")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments} ")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }
}
