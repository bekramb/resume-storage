package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) == -1) {
            if (size <= storage.length) {
                storage[size] = r;
                size++;
            }else{
                System.out.println("Storage is full!");
            }
        }else{
            System.out.println("Resume with " + r.getUuid() + " already exists!");
        }
    }

    @Override
    public int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                index = i;
                break;
            }
        }
        return index;
    }
}

