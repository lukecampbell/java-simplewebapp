package com.asascience.models;

import junit.framework.TestCase;

public class TestUser extends TestCase {
    public void testUser() {
        User bob = new User(0, "Bob", 35);
        assertEquals(bob.getName(), "Bob");
        assertEquals(bob.getId(), 0);
        assertEquals(bob.getAge(), 35);
    }
}

