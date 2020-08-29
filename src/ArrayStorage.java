/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int sizeStorage = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < sizeStorage; i++) {
            storage[i] = null;
        }
        sizeStorage = 0;
    }

    void save(Resume r) {
        if (find(r) == -1) {           // it will be unique value
            storage[sizeStorage] = r;
            ++sizeStorage;
        }
    }

    /**
     * @return index of UUID in storage
     */
    int find(String uuid) {
        int idFound = -1;
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid == uuid) {
                idFound = i;
                break;
            }
        }
        return idFound;
    }
    /**
     * Overriding function FINE. For case when source is string`s type
     * @return index of UUID in storage
     */
    int find(Resume r) {
        int idFound = -1;
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid == r.uuid) {
                idFound = i;
                break;
            }
        }
        return idFound;
    }

    Resume get(String uuid) {
        int idFound = find(uuid);
        if (idFound > -1) {
            return storage[idFound];
        } else {
            return null;
        }
    }

    void delete(String uuid) {
        int idFound = find(uuid);
        int i;
        if (idFound > -1) {
            for (i = idFound; i < sizeStorage - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[sizeStorage - 1] = null;
            sizeStorage = sizeStorage - 1;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resume = new Resume[sizeStorage];
        for (int i = 0; i < sizeStorage; i++) {
            resume[i] = storage[i];
        }
        return resume;
    }

    int size() {
        return sizeStorage;
    }
}
