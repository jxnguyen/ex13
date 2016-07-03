package linkedList;

// NODE	| The Node class represents a single element of a linked list
// 			|	data structure.
//
public class Node <T> {

		public T value;
		Node<T> next;

		Node(T v) {
				this.value = v;
		}
}
