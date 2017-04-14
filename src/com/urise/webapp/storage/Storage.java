package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public interface Storage {


    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void update(Resume r);

    void delete(String uuid);

    Resume[] getAll();

    int size();

}

