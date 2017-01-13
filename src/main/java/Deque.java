import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {    
    private class Node {
        Item item;
        Node next;
        Node prev;
    }
    private Node first, last;
    private int count = 0;

    public Deque() {
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("Can't add null item.");
        }
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            last = first;
        } else {
            oldfirst.prev = first;
            first.next = oldfirst;
        }
        count++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("Can't add null item.");
        }
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
            last.prev = oldlast;
        }
        count++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Can't remove an item from an empty list.");
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        count--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Can't remove an item from an empty list.");
        }
        Item item = last.item;
        last = last.prev;
        if (isEmpty()) {
            first = null;
        }
        count--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Remove not supported.");
        }
    }
}