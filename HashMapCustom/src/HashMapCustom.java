import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by rgadbois on 7/21/16.
 */
public class HashMapCustom<K, V> {
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock read  = readWriteLock.readLock();
    private final Lock write = readWriteLock.writeLock();

    private Entry<K, V>[] table;   //Array of Entry.
    private int capacity = 4;  //Initial capacity of HashMap

    public HashMapCustom() {
        table = new Entry[capacity];
    }

    // class provides its own hash function
    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K newKey, V data) {
        if (newKey == null)
            return;    //does not allow to store null.
        int hash = hash(newKey);
        Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);
        write.lock();
        try {
            if (table[hash] == null) {
                table[hash] = newEntry;
            } else {
                Entry<K, V> previous = null;
                Entry<K, V> current = table[hash];
                while (current != null) { //we have reached last entry of bucket.
                    if (current.key.equals(newKey)) {
                        if (previous == null) {  //node has to be insert on first of bucket.
                            newEntry.next = current.next;
                            table[hash] = newEntry;
                            return;
                        } else {
                            newEntry.next = current.next;
                            previous.next = newEntry;
                            return;
                        }
                    }
                    previous = current;
                    current = current.next;
                }
                previous.next = newEntry;
            }
        } finally {
            write.unlock();
        }
    }

    public V get(K key) {
        int hash = hash(key);
        read.lock();
        try {
            if (table[hash] == null) {
                return null;
            } else {
                Entry<K, V> temp = table[hash];
                while (temp != null) {
                    if (temp.key.equals(key))
                        return temp.value;
                    temp = temp.next; //return value corresponding to key.
                }
                return null;   //returns null if key is not found.
            }
        } finally {
            read.unlock();
        }
    }

    public boolean remove(K deleteKey) {
        if (deleteKey == null) {
            return false;
        }
        int hash = hash(deleteKey);
        write.lock();
        try {
            if (table[hash] == null) {
                return false;
            } else {
                Entry<K, V> previous = null;
                Entry<K, V> current = table[hash];

                while (current != null) { //we have reached last entry node of bucket.
                    if (current.key.equals(deleteKey)) {
                        if (previous == null) {  //delete first entry node.
                            table[hash] = table[hash].next;
                            return true;
                        } else {
                            previous.next = current.next;
                            return true;
                        }
                    }
                    previous = current;
                    current = current.next;
                }
                return false;
            }
        } finally {
            write.unlock();
        }
    }
}