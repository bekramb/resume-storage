/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        size = 0;
    }

    void save(Resume r) {
        if (getIndex(r.uuid) == -1 && r.uuid != null) {
            if (size <= storage.length) {
                storage[size] = r;
                size++;
            }
        }
    }

    Resume get(String uuid) {
        int index = getIndex(uuid);
        Resume r = null;
        if (index != -1) {
            r = storage[index];
        }
        return r;
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
            size--;
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

    /**
     * @param uuid
     * @return index if storage contains Resume with uuid otherwise -1
     */


    int getIndex(String uuid) {
        int index = -1;
        if (null == uuid || uuid.isEmpty()){
            return index;
        }
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                index = i;
                break;
            }
        }
        return index;
    }
}

