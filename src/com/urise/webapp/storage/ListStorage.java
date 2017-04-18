package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {

     private List<Resume> storage = new LinkedList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume r) {
        int index = storage.indexOf(r);
        if (index != -1) {
            storage.set(index, r);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        if (!storage.contains(r)) {
            storage.add(r);
        }else{
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = storage.indexOf(new Resume(uuid));
        if (index != -1) {
            return storage.get(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void delete(String uuid) {
        if (!storage.remove(new Resume(uuid))) {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        Resume[] arr = new Resume[storage.size()];
        return storage.toArray(arr);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
