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

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
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

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            storage[index] = r;
        }else{
            System.out.println("There is no resume with " + r.getUuid());
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
            size--;
        }else{
            System.out.println("There is no resume with " + uuid);
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    /**
     * @param uuid
     * @return index if storage contains com.urise.webapp.model.Resume with uuid otherwise -1
     */
    protected abstract int getIndex(String uuid);

}

