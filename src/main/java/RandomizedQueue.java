import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int count = 0;

    public RandomizedQueue(int capacity) {
        s = (Item[]) new Object[capacity];
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
        if (count == s.length)
            resize(2 * s.length);
        s[count++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Can't remove an item from an empty list.");
        }
        int position = StdRandom.uniform(count);
        Item item = s[position];
        s[position] = s[count - 1];
        s[count - 1] = null;
        count--;
        if (count > 0 && count == s.length / 4)
            resize(s.length / 2);
        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < count; i++)
            copy[i] = s[i];
        s = copy;
    }

    public Item sample() {
        return s[StdRandom.uniform(count)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        int items = count;
        int[] posarray = new int[count];

        public RandomizedQueueIterator() {
            for (int i = 0; i < count; i++) {
                posarray[i] = i;
            }
            StdRandom.shuffle(posarray);
        }

        @Override
        public boolean hasNext() {
            return items != 0;
        }

        @Override
        public Item next() {
            Item item = s[posarray[items - 1]];
            items--;
            return item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Remove not supported.");
        }
    }
}