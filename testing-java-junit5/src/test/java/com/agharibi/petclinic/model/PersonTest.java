package com.agharibi.petclinic.model;

import com.agharibi.petclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void groupAssertions() {
        // given
        Person person = new Person(1L, "James", "Stevens");

        // then
        assertAll("Testing person properties",
            () -> assertEquals( "James", person.getFirstName()),
            () -> assertEquals( "Stevens", person.getLastName()));
    }

    @Test
    void groupAssertionsMessages() {
        Person person = new Person(2L, "Armen", "Gharibi");

        assertAll("Group assertions with messages",
            () -> assertTrue(2L == person.getId(), "Person Id failed"),
            () -> assertEquals("Armen", person.getFirstName(), "First name test failed"),
            () -> assertEquals("Gharibi", person.getLastName(), "Last name test failed"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("repeated functional test")
    void repeatedTest() {
        // TODO - impl
    }

    @RepeatedTest(value = 5)
    void repeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }
}
