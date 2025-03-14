package barkingdog.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
    public static void main(String[] args) {
        SimpleDeque simple = new SimpleDeque();

        simple.pushBack(30); // 30
        System.out.println(simple.front()); // 30
        System.out.println(simple.back()); // 30
        simple.pushFront(25); // 25 30
        simple.pushBack(12); // 25 30 12
        System.out.println(simple.back()); // 12
        simple.pushBack(62); // 25 30 12 62
        simple.popFront(); // 30 12 62
        System.out.println(simple.front()); // 30
        simple.popFront(); // 12 62
        System.out.println(simple.back()); // 62

        System.out.println("===Deque===");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(10); // 10
        deque.offerLast(50); // 10 50
        deque.offerFirst(24); // 24 10 50
        for (Integer i : deque) {
            System.out.print(i + " "); // 24 10 50
        }
        System.out.println();
        System.out.println(deque.size()); // 3
        System.out.println(deque.isEmpty() ? "empty" : "not empty"); // not empty
        deque.pollFirst(); // 10 50
        deque.pollLast(); // 10
        System.out.println(deque.peekLast()); // 10
        deque.offerLast(72); // 10 72
        System.out.println(deque.peekFirst()); // 10
        deque.offerLast(12); // 10 72 12
        System.out.println(deque.peekLast()); // 12
        deque.clear();
        System.out.println(deque.isEmpty() ? "empty" : "not empty"); // empty
    }
}
