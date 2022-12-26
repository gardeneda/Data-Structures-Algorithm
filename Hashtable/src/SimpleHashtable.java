public class SimpleHashtable {

    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredEmployee[10];
    }

    // Because this is a simple hash table it doesn't handle collisions.
    // This means that if we attain a key with the same hash value as another,
    // It won't be added into the hash table. This is a simple demonstration.
    // In a more robust implementation, we would be checking the load factor
    // and re-sizing the array if necessary.
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        // If occupied, initiate Linear Probing.
        // Will wrap if it hits the end of the array.
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            // Sets up the first probe.
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        // This is triggered if the entire hash table is full.
        if (occupied(hashedKey)) {
            System.out.println("Sorry, there's already an employee at position: " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    // Linear Probing used, so get() should reflect this as well.
    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        // Rehash-ing process.
        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }

        return employee;
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    private int hashKey(String key) {
//        return key.length() % hashtable.length;
        return Math.abs(key.hashCode() % hashtable.length);
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        // Linear Probing
        int stopIndex = hashedKey;
        // Sets up the first probe.
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        else {
            return -1;
        }
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("Empty");
            }
            else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }
}
