import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T>{

    private Node<Integer> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>(null, 0, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    private static class Node<T>{
        public Node prev;
        public T item;
        public Node next;

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public void addFirst(T x) {
        Node<T> node = new Node<>(this.sentinel, x, this.sentinel.next);
        this.sentinel.next.prev = node;
        this.sentinel.next = node;
        size ++;
    }

    @Override
    public void addLast(T x) {
        Node<T> node = new Node<>(this.sentinel.prev, x, this.sentinel);
        this.sentinel.prev.next = node;
        this.sentinel.prev = node;
        size ++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node<T> temp = this.sentinel.next;
        while (temp != this.sentinel){
            returnList.add(temp.item);
            temp = temp.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(sentinel.next == sentinel){
            return null;
        }else {
            T item = (T) sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return item;
        }
    }

    @Override
    public T removeLast() {
        if(sentinel.prev == sentinel){
            return null;
        }else {
            T item = (T) sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return item;
        }
    }

    @Override
    public T get(int index) {
        if(sentinel.next == sentinel){
            return null;
        }
        Node temp = sentinel.next;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return (T) temp.item;
    }

    @Override
    public T getRecursive(int index) {
        if(sentinel.next == sentinel){
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    public T getRecursiveHelper(int index, Node temp){
        if(index == 0){
            return (T) temp.item;
        }else {
            return getRecursiveHelper(index - 1, temp.next);
        }
    }
}
