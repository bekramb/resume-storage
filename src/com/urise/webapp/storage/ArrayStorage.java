package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        size = 0;
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) == -1) {
            if (size <= storage.length) {
                storage[size] = r;
                size++;
            }else{
                System.out.println("Storage is full!");
            }
        }else{
            System.out.println("Resume with such uuid already exists!");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        Resume r = null;
        if (index != -1) {
            r = storage[index];
        }else{
            System.out.println("There is no resume with such uuid");
        }
        return r;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            storage[index] = r;
        }else{
            System.out.println("There is no resume with such uuid");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
            size--;
        }else{
            System.out.println("There is no resume with such uuid");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] arr = new Resume[size];
        for (int i = 0; i < size; i++) {
            arr[i] = storage[i];
        }
        return arr;
    }

    public int size() {
        return size;
    }

    /**
     * @param uuid
     * @return index if storage contains com.urise.webapp.model.Resume with uuid otherwise -1
     */
    public int getIndex(String uuid) {
        int index = -1;
        if (null == uuid || uuid.isEmpty()){
            return index;
        }
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                index = i;
                break;
            }
        }
        return index;
    }
}

