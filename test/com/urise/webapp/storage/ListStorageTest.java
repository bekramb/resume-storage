package com.urise.webapp.storage;

import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class ListStorageTest extends AbstractStorageTest {
    public ListStorageTest() {
        super(new ListStorage());
    }
}