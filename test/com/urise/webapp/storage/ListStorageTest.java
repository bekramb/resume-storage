package com.urise.webapp.storage;

import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class ListStorageTest extends AbstractStorageTest {
    @BeforeClass
    public static void init() {
        storage = new ListStorage();
    }
}