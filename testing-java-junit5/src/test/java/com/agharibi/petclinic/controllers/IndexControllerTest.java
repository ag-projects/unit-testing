package com.agharibi.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test proper view name is returned from index page")
    @Test
    void index() {
        assertEquals("index", controller.index(), "This message will be displayed when this test fails");
    }

    @DisplayName("Test exception")
    @Test
    void erroneousHandler() {
        assertThrows(ValueNoFoundException.class, () -> {
            controller.erroneousHandler();
        });
    }

    @Test
    void testTimeouts() {
        assertTimeout(Duration.ofMillis(1000), () -> {
                Thread.sleep(100);
                System.out.println("The second statement in test method");
            });
    }

    @Disabled
    @Test
    void testTimeoutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("The second statement in test preemptive method");
        });
    }

    @Test
    void testAssumptionsTrue() {
        assumeTrue("STAGE".equalsIgnoreCase(System.getenv("STAGE_ENV")));
    }

    @Test
    void testEnvAssumptionTrue() {
        assumeTrue("DEV".equalsIgnoreCase("DEV"));
    }
}
