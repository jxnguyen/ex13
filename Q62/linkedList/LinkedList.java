package linkedList;

// LINKED LIST | The LinkedList class defines a generic singly linked list
// 						 | data structure, where only the head of the list is known.
//
public class LinkedList <T> {

    Node<T> head;
		int length;

		// CONSTRUCTOR | Linked list from array.
		//
		public LinkedList(T[] array) {
			for (T x : array) insert(x);
		}

		// INSERT | Insert value at beginning of list.
		//
		public void insert(T v) {
			Node<T> node = new Node<T>(v);
			node.next = head;
			head = node;
			length++;
		}

		// INSERT | Insert new value after node k & return true, else if k is
		//				|	not in the list, return false.
		//
		public boolean insert(T v, Node<T> k) {
			// if k is in list
			if (isElem(k)) {
				Node<T> node = new Node<T>(v);
				node.next = k.next;
				k.next = node;
				length++;
				return true;
			}
			else return false;
		}

		// DELETE | Delete head of list & return true, else if list empty
		//				| return false.
		//
		public boolean delete() {
			// if list not empty
			if (length > 0) {
				head = head.next;
				length--;
				return true;
			}
			else return false;
		}

		// DELETE | Delete node k from list & return true, else if k not
		//			 	| in list, return false.
		//
		public boolean delete(Node<T> k) {
			// if k is head
			if (head == k) return delete();
			// traverse list
			for (Node<T> n = head; n != null; n = n.next) {
				// if next node is k
				if (n.next == k) {
					// exclude k
					n.next = k.next;
					length--;
					return true;
				}
			}
			// k not in list
			return false;
		}

		// IS ELEM | Return true if k is in the list, else false.
		//
		public boolean isElem(Node<T> k) {
			// traverse list
			for (Node<T> n = head; n != null; n = n.next)
				if (n == k) return true;

			return false;
		}

		// NODE FOR VALUE | Return first node with value i, else null.
		//
		public Node<T> nodeForValue(T v) {
			for (Node<T> n = head; n != null; n = n.next)
				if (n.value == v) return n;

			return null;
		}

		// TO STRING | Return String representation of list.
		//
		public String toString() {
			String s = "";
			for (Node<T> n = head; n != null; n = n.next)
				s += n.value + " -> ";

			s += "null";
			return s;
		}
}
