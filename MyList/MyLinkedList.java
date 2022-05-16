public class MyLinkedList<T> implements MyList<T> {

    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;
        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;
    public MyLinkedList() {}

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if (index > length && index < 0) {
            System.out.println("Index Out Of Bounds Exception");
            return;
        }

        if (index == length) add(item);
        else {
            MyNode<T> node = head;
            while (index != 0) {
                node = node.next;
                index--;
            }

            MyNode<T> newNode = new MyNode<>(item);
            newNode.prev = node.prev;
            if (newNode.prev != null) {
                newNode.prev.next = newNode;
            } else {
                head = newNode;
            }

            newNode.next = node;
            node.prev = newNode;
            length++;
        }
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index >= length &&  index < 0) {
            System.out.println("Index Out Of Bounds Exception");
            return null;
        }

        MyNode<T> node = head;
        while (index != 0) {
            node = node.next;
            index--;
        }
        T item = (T) node;

        if (node.prev == null) {
            head = head.next;
        }
        else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            tail = tail.prev;
        }
        else {
            node.next.prev = node.prev;
        }
        length--;

        return item;
    }

    @Override
    public void clear() {
        MyNode<T> node = head;
        while(node.next != null){
            node = node.next;
            node.prev = null;
        }
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("Index should be positive and less than size");

        MyNode<T> temp = head;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> node = head;
        int index = 0;
        while (node != null){
            if (node.data.equals(o)) return index;
            node = node.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> node = tail;
        int index = length - 1;
        while (node != null){
            if (node.data.equals(o)) return index;
            node = node.prev;
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        int index = indexOf(o);
        if (index != -1){
            return true;
        }
        return false;
    }
}
