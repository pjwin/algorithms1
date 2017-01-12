import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node first, last;
	private int count = 0;
	
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	public Deque() {
		// construct an empty deque
	}

	public boolean isEmpty() {
		return first == null || last == null;
	}

	public int size() {
		return count;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new java.lang.NullPointerException("Can't add null item.");
		}
		// add the item to the front
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.prev = null;
		if (isEmpty()) {
			last = first;
		} else {
			oldfirst.prev = first;
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
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
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
	
	private class DequeIterator implements Iterator<Item>{
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!this.hasNext()) {
				throw new java.util.NoSuchElementException("There are no more items.");
			}
			return null;
		}
		
		@Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException("Remove not supported.");
		}
	}
	
	public static void main(String[] args) {
		Deque d = new Deque();
		System.out.println(d.count);
		System.out.println(d.isEmpty());
	}
}