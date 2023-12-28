import deque.MaxArrayDeque;
import org.junit.jupiter.api.*;
import deque.Deque;
import deque.ArrayDeque;
import deque.LinkedListDeque;

import java.util.Comparator;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class MaxArrayDequeTest {

    @Test
    public void addLastTestBasicWithoutToList() {
        Deque<String> lld1 = new LinkedListDeque<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1).containsExactly("front", "middle", "back");
    }


    @Test
    public void testEqualDeques() {
        Deque<String> lld1 = new LinkedListDeque<>();
        Deque<String> lld2 = new LinkedListDeque<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        lld2.addLast("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertThat(lld1).isEqualTo(lld2);
    }

    @Test
    public void toStringTest(){
        Deque<String> lld1 = new LinkedListDeque<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        assertThat(lld1.toString()).isEqualTo("{front, middle, back}");
    }

    @Test
    public void maxArrayDequeTest(){
        Comparator<String> cs = new MaxArrayDeque.StringComparator();
        Comparator<Integer> ci = new MaxArrayDeque.IntComparator();
        MaxArrayDeque<String> lld1 = new MaxArrayDeque<>(cs);
        MaxArrayDeque<Integer> lld2 = new MaxArrayDeque<>(ci);

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        assertThat(lld1.max()).isEqualTo("middle");

        lld2.addLast(1);
        lld2.addLast(2);
        lld2.addLast(6);
        assertThat(lld2.max()).isEqualTo(6);
    }
}
