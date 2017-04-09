/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i <storage.length ; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length ; i++) {
            if (storage[i]== null){
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume r = null;
        for (int i = 0; i < storage.length ; i++) {
            if(storage[i] != null){
                if (uuid.equals(storage[i].uuid)) {
                    r = storage[i];
                    break;
                }
            }
        }
        return r;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length ; i++) {
            if(storage[i] != null) {
                if (uuid.equals(storage[i].uuid)) {
                    storage[i] = null;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] arr = new Resume[size()];
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]!= null){
                arr[index] = storage[i];
                index++;
            }
        }
        return arr;
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length ; i++) {
            if (storage[i] != null){
                count++;
            }
        }
        return count;
    }
}

