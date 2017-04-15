package com.urise.webapp.storage;

import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    @BeforeClass
    public static void init() {
        storage = new SortedArrayStorage();
    }

}