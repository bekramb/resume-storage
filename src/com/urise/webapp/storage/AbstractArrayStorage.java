package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        Resume r = null;
        if (index != -1) {
            r = storage[index];
        }else{
            System.out.println("Resume " + uuid + " not exist");
        }
        return r;
    }

    protected abstract int getIndex(String uuid);

}

