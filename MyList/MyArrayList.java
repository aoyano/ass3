public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }


    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (length + 1 <= index)
            increaseCapacity();
        for(int i=length-1;i>=index;i--) {
            arr[i+1] = arr[i];
        }
        arr[index] = item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size(); i++) {
            if (item.equals(arr[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        {
            Object item = arr[index];
            for(int i=index;i<length-1;i++) {
                arr[i]=arr[i+1];
            }
            arr[length-1] = null;
            length--;
            return (T) item;
        }
    }

    @Override
    public void clear() {
        for(Object o: arr) o = null;
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];
        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        {
            for (int i = 0; i < length; i++) {
                if (o.equals(arr[i])){
                    return i;
                }
            }
            return -1;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        {
            for (int i = length - 1; i >= 0; i--) {
                if (o.equals(arr[i])){
                    return i;
                }
            }
            return -1;
        }
    }

    @Override
    public void sort() {
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                int tempI=(Integer)arr[i];
                int tempJ=(Integer) arr[j];
                if(tempI>tempJ){
                    arr[i]=tempJ;
                    arr[j]= tempI;
                }
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        if (indexOf(o) != -1) return true;
        return false;
    }
}
