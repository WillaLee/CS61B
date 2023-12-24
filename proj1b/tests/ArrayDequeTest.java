import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDequeTest {

     @Test
     @DisplayName("ArrayDeque has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }

    @Test
    public void addFirstTest(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.addFirst(8);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(6);
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(0);

        assertThat(arrayDeque.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8).inOrder();
    }

    @Test
    public void addLastTest(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.addLast(8);
        arrayDeque.addLast(7);
        arrayDeque.addLast(6);
        arrayDeque.addLast(5);
        arrayDeque.addLast(4);
        arrayDeque.addLast(3);
        arrayDeque.addLast(2);
        arrayDeque.addLast(1);
        arrayDeque.addLast(0);

        assertThat(arrayDeque.toList()).containsExactly(8, 7, 6, 5, 4, 3, 2, 1, 0).inOrder();
    }

    @Test
    public void addFirstAndAddLastTest(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.addLast(8);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(6);
        arrayDeque.addLast(9);
        arrayDeque.addFirst(5);
        arrayDeque.addLast(10);
        arrayDeque.addLast(11);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(3);
        assertThat(arrayDeque.toList()).containsExactly(3, 4, 5, 6, 7, 8, 9, 10, 11).inOrder();
    }

    @Test
    public void toListTest(){
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        arrayDeque.addFirst("0");
        arrayDeque.addLast("1");

        assertThat(arrayDeque.toList()).containsExactly("0", "1").inOrder();
    }

    @Test
    public void sizeTest(){
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        assertThat(arrayDeque.size()).isEqualTo(0);

        arrayDeque.addFirst("0");
        arrayDeque.addLast("1");

        assertThat(arrayDeque.size()).isEqualTo(2);
    }

    @Test
    public void removeFirstTest(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        assertThat(arrayDeque.removeFirst()).isNull();

        arrayDeque.addLast(8);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(6);
        arrayDeque.addLast(9);
        arrayDeque.addFirst(5);
        arrayDeque.addLast(10);
        arrayDeque.addLast(11);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(3);
        arrayDeque.removeFirst();
        arrayDeque.removeFirst();
        assertThat(arrayDeque.toList()).containsExactly(5, 6, 7, 8, 9, 10, 11).inOrder();
    }

    @Test
    public void removeLastTest(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        assertThat(arrayDeque.removeLast()).isNull();

        arrayDeque.addFirst(8);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(6);
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(3);
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        assertThat(arrayDeque.toList()).containsExactly(3, 4, 5, 6).inOrder();
    }

    @Test
    public void removeFirstAndRemoveLastTest(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.addLast(8);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(6);
        arrayDeque.addLast(9);
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        assertThat(arrayDeque.toList()).containsExactly(6).inOrder();

        arrayDeque.addFirst(5);
        arrayDeque.addLast(7);
        arrayDeque.addLast(8);
        arrayDeque.removeFirst();
        arrayDeque.removeLast();
        assertThat(arrayDeque.toList()).containsExactly(6, 7).inOrder();
    }

    @Test
    public void getTest(){
         ArrayDeque<String> arrayDeque = new ArrayDeque<>();

         assertThat(arrayDeque.get(0)).isNull();

         arrayDeque.addFirst("0");
         arrayDeque.addLast("1");

         assertThat(arrayDeque.get(0)).isEqualTo("0");
    }

}
