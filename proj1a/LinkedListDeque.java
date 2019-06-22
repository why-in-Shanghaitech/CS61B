/**
 * LinkedListDeque
 */
public class LinkedListDeque<T> {

    private class Node {
    
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T n, Node q) {
            prev = p;
            item = n;
            next = q;
        }

    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node insertNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = insertNode;
        sentinel.next = insertNode;
        size++;
    }

    public void addLast(T item) {
        Node insertNode = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = insertNode;
        sentinel.prev = insertNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel;
        for (int i = 0; i < size; i++) {
            p = p.next;
            System.out.print(p.item);
            System.out.print(" ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            System.out.print("Warning: Nothing to remove.");
            return null;
        }

        T result = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            System.out.print("Warning: Nothing to remove.");
            return null;
        }

        T result = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return result;
    }

    public T get(int index) {
        Node temp = sentinel.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    private T getRecursiveNode(int index, Node node) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursiveNode(index - 1, node.next);
        }
    }

    public T getRecursive(int index) {
        return getRecursiveNode(index, sentinel.next);
    }

}