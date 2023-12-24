import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T>{

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 7;
        nextLast = 0;
        size = 0;
    }

    private void resize(int capacity){
        T[] tempItems = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            tempItems[i] = get(i);
        }
        items = tempItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }
    @Override
    public void addFirst(T x) {
        if(nextFirst - nextLast == 1){
            resize(items.length * 2);
        }
        items[nextFirst] = x;
        if (nextFirst - 1 < 0){
            nextFirst = nextFirst - 1 + items.length;
        }else {
            nextFirst = nextFirst - 1;
        }
        size++;
    }

    @Override
    public void addLast(T x) {
        if(nextFirst - nextLast == 1){
            resize(items.length * 2);
        }
        items[nextLast] = x;
        int arrayStorageSize = items.length;
        if (nextLast + 2 > arrayStorageSize){
            nextLast = nextLast + 1 - arrayStorageSize;
        }else {
            nextLast = nextLast + 1;
        }
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            returnList.add(get(i));
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
        int arrayStorageSize = items.length;
        if(size == 0){
            return null;
        }else if (nextFirst + 2 > arrayStorageSize){
            nextFirst = nextFirst + 1 - arrayStorageSize;
        }else {
            nextFirst = nextFirst + 1;
        }
        T tempItem = items[nextFirst];
        items[nextFirst] = null;
        size--;
        if(size < items.length * 0.25){
            resize((int) Math.round(items.length * 0.5));
        }
        return tempItem;
    }

    @Override
    public T removeLast() {
        if(size == 0){
            return null;
        }else if (nextLast - 1 < 0){
            nextLast = nextLast - 1 + items.length;
        }else {
            nextLast = nextLast - 1;
        }
        T tempItem = items[nextLast];
        items[nextLast] = null;
        size--;
        if(size < items.length * 0.25){
            resize((int) Math.round(items.length * 0.5));
        }
        return tempItem;
    }

    @Override
    public T get(int index) {
        int arrayStorageSize = items.length;
        if(size == 0 || index >= size){
            return null;
        }else if (index + nextFirst + 2 > arrayStorageSize){
            return items[index + nextFirst + 1 - arrayStorageSize];
        }else {
            return items[index + nextFirst + 1];
        }
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
