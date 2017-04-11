/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
            size = 0;
    }

    void save(Resume r) {
        if (size <= storage.length) {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        Resume r = null;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                r = storage[i];
                break;

            }
        }
        return r;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                System.arraycopy(storage, i+1, storage, i, size - i);
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] arr = new Resume[size];
        for (int i = 0; i < size; i++) {
            arr[i] = storage[i];
        }
        return arr;
    }

    int size() {
        return size;
    }
}

