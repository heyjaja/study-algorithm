package barkingdog.linked;

public class LinkedListTest {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        insert_test(list);
        erase_test(list);
    }

    static void insert_test(SimpleLinkedList list) {
        System.out.println("====insert_test====");
        list.insert(0, 10); // 10(address=1)
        list.traverse();
        list.insert(0, 30); // 30(address=2) 10
        list.traverse();
        list.insert(2, 40); // 30 40(address=3) 10
        list.traverse();
        list.insert(1, 20); // 30 40 10 20(address=4)
        list.traverse();
        list.insert(4, 70); // 30 40 10 20 70(address=5)
        list.traverse();
    }

    static void erase_test(SimpleLinkedList list){
        System.out.println("====erase_test====");
        list.erase(1); // 30 40 20 70
        list.traverse();
        list.erase(2); // 40 20 70
        list.traverse();
        list.erase(4); // 40 70
        list.traverse();
        list.erase(5); // 40
        list.traverse();
    }
}
