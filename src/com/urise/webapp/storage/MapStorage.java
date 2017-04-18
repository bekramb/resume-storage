package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new TreeMap();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume r) {
        if (storage.containsKey(r.getUuid())) {
            storage.put(r.getUuid(), r);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        if (!storage.containsKey(r.getUuid())) {
            storage.put(r.getUuid(), r);
        } else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        Resume r = storage.get(uuid);
        if (r != null) {
            return r;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void delete(String uuid) {
        Resume r = storage.remove(uuid);
        if (r == null) {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        Resume[] arr = new Resume[storage.size()];
        return storage.values().toArray(arr);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
