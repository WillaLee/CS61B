import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{
    private class BSTNode {
        public K item;
        public V value;
        public BSTNode left;
        public BSTNode right;

        public BSTNode(K item, V value) {
            this.item = item;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private BSTNode root;
    private int size;

    public BSTMap() {
        root = null;
    }

    @Override
    public void put(K key, V value) {
        root = putRecursive(root, key, value);
    }

    private BSTNode putRecursive(BSTNode pointer, K key, V value){
        if (pointer == null) {
            pointer = new BSTNode(key, value);
            size++;
        } else if (key.compareTo(pointer.item) == 0) {
            pointer.value = value;
        } else if (key.compareTo(pointer.item) > 0) {
            pointer.right = putRecursive(pointer.right, key, value);
        } else {
            pointer.left = putRecursive(pointer.left, key, value);
        }
        return pointer;
    }

    private BSTNode findRecursive(BSTNode pointer, K key){
        if (pointer == null) {
            return null;
        }
        if (key.compareTo(pointer.item) == 0){
            return pointer;
        } else if (key.compareTo(pointer.item) > 0) {
            return findRecursive(pointer.right,key);
        } else {
            return findRecursive(pointer.left,key);
        }
    }

    @Override
    public V get(K key) {
        BSTNode pointer = findRecursive(root,key);
        if (pointer == null) {
            return null;
        } else {
            return pointer.value;
        }
    }

    @Override
    public boolean containsKey(K key) {
        return findRecursive(root, key) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapKeyIterator();
    }

    private class BSTMapKeyIterator implements Iterator{

        BSTNode pointer = root;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }


}
