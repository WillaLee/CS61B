package deque;

import java.util.Comparator;
import java.util.Objects;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.c = c;
    }

    public T max(){
        if (isEmpty()){return null;}
        T max = get(0);
        for(T item : this){
            if (c.compare(max, item) < 0){
                max = item;
            }
        }
        return max;
    }

    public T max(Comparator<T> c){
        if (isEmpty()){return null;}
        T max = get(0);
        for(T item : this){
            if (c.compare(max, item) < 0){
                max = item;
            }
        }
        return max;
    }

    public static class StringComparator implements Comparator<String>{
        @Override
        public int compare(String item1, String item2) {
            return item1.compareTo(item2);
        }
    }

    public static class IntComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer item1, Integer item2) {
            return item1 - item2;
        }
    }

}
