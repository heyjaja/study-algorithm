package barkingdog.queue;

public class QueueTest {
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue();
        queue.push(10); queue.push(20); queue.push(30);
        System.out.println(queue.front()); // 10
        System.out.println(queue.back()); // 30
        queue.pop(); queue.pop();
        queue.push(15); queue.push(25);
        System.out.println(queue.front()); // 30
        System.out.println(queue.back()); // 25
    }
}
