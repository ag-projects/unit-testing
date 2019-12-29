package com.agharibi.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}
