package linkedList;

// LINED QUEUE | Subclass of LinkedList, adding tail/append functionality.
//
public class LinkedQueue<T> extends LinkedList<T> {

	Node<T> tail;

	// CONSTRUCTOR
	//
	public LinkedQueue() {
		super();
	}

	// CONSTRUCTOR | Linked list from array.
	//
	public LinkedQueue(T[] array) {
		super(array);
	}

	// INSERT | Insert value at beginning of list.
	//
	public void insert(T v) {
		super.insert(v);
		// if new node is last node
		if (head.next == null) tail = head;
	}

	// INSERT | Insert new value after node k & return true, else if k is
	//				|	not in the list, return false.
	//
	public boolean insert(T v, Node<T> k) {
		// insert node & set tail, if needed
		boolean success = super.insert(v,k);
		if (success && k.next.next == null) tail = k.next;
		return success;
	}

	// DELETE | Delete head of list & return true, else if list empty
	//				| return false.
	//
	public boolean delete() {
		// delete head
		boolean success = super.delete();
		// update tail if needed
		if (success && length == 0) tail = null;
		return success;
	}

	// DELETE | Delete node k from list & return true, else if k not
	//			 	| in list, return false.
	//
	public boolean delete(Node<T> k) {
		// delete
		boolean success = super.delete(k);
		// if tail deleted
		if (success && tail == k) {
			tail = null;
			// update tail
			for (Node<T> n : this)
				if (n.next == null) tail = n;
		}
		return success;
	}

	// APPEND | Append node to end of list
	//
	public void append(T v) {
		// if list empty
		if (isEmpty()) insert(v);
		else {
			// insert after tail & update tail
			Node<T> node = new Node<T>(v);
			tail.next = node;
			tail = node;
			length++;
		}
	}

	// APPEND | Append linked list to end of list
	//
	public void append(LinkedQueue<T> l) {
		// if given list is empty, do nothing
		if (l.isEmpty()) return;
		// if list empty, take over list
		if (isEmpty()) {
			head = l.head;
			tail = l.tail;
			length = l.length;
		}
		else {
			// concatenate & update tail
			tail.next = l.head;
			tail = l.tail;
			length += l.length;
		}
	}
}
