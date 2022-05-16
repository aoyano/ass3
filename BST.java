public class BST<K extends Comparable<K>, V, root, node> {
    private Node root;
    private class Node
    {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val)
        {
            this.key = key;
            this.val = val;
        }
    }
    public BST(){
        root = null;
    }
    public void put(Node root, K key, V val) {
        put(this.root, key, val);
    }
    private Node put( K key, V val){}
    public V get(K key) {}

    public void delete(Node root, K key) {
        delete(this.root, key);
    }

    public Iterable<K> iterator() {
        MyQueue<K> myQueue = new MyQueue<K>();
    }
}
