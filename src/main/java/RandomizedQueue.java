import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    private int count = 0;

    public RandomizedQueue() {
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("Can't add null item.");
        }
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        count++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Can't remove an item from an empty list.");
        }
        return null;
        // remove and return a random item
    }

    public Item sample() {
        // return (but do not remove) a random item
        return null;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            // TODO
            return false;
        }

        @Override
        public Item next() {
            // TODO
            return null;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Remove not supported.");
        }
    }
}