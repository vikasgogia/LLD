public class MyHashMap<K,V> {

    /**
     * Reference:
     * https://github.com/vikasgogia/Eclipse/blob/master/Java_Tutorial_CB/src/HashMap/HashTable.java
     */

    // Linked List node
    class Entry<K,V> {
        K key;
        V value;
        Entry next;

        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int  INITIAL_SIZE = 1<<4; //16
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private Entry[] hashTable;

    public MyHashMap() {
        hashTable= new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length; // java default hashcode function & compression
        Entry node = hashTable[hashCode];

        if(node == null) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        }
        else {
            Entry previousNode = node;
            while (node != null) {
                // overwrite existing key-value
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            previousNode.next = new Entry(key,value);
        }

        // there could possibly a rehash() function which takes care of load factor
        // load factor  = 0.75
        // if (LL size/ bucket array size] > 0.75 --> rehash()
        // twice the size of the bucket array
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null) {
            if(node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }
}
