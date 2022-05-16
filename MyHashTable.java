import static sun.jvm.hotspot.code.CompressedStream.L;

public class MyHashTable <K, V>{
    private class HashNode<K, V> {
        public HashNode(K key, V value) {
        }

        private class HashCode<K, V> {
            private K key;
            private V value;
            private HashNode<K, V> next;

            public void HashNode(K key, V value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "{" + key + " " + value + "}";
            }
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {...}

    public void put(K key, V value) {
        int hashIndex = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainArray[hashIndex] != null){
            newNode.next = chainArray[hashIndex];
        }
        chainArray[hashIndex] = newNode;
    }

    public V get(K key) {
        int hashIndex = hash(key);
        HashNode<K, V> cur = chainArray[hashIndex];
    }

    public V remove(K key) {
        int hashIndex = hash(key);
        HashNode<K, V> cur = chainArray[hashIndex];
        HashNode<K, V> pre = null;
    }

    public boolean contains(V value) {
        HashNode <K, V> node;
        for (int i = 0; i < M; i++){
            node = chainArray[i];
            while (node != null){}
        }
    }

    public K getKey(V value) {
        HashNode <K, V> node;
        for (int i = 0; i < M; i++){
            node = chainArray[i];
            while (node != null){}
        }
    }
}
