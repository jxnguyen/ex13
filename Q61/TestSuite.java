
class TestSuite {

	public static void main(String[] args) {

		BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
		BinaryTree<Integer> a = new BinaryTree<Integer>(2);
		BinaryTree<Integer> b = new BinaryTree<Integer>(3);
		BinaryTree<Integer> c = new BinaryTree<Integer>(4);
		BinaryTree<Integer> d = new BinaryTree<Integer>(5);
		BinaryTree<Integer> e = new BinaryTree<Integer>(6);

		tree.left  = a;
		tree.right = b;
		a.left     = c;
		a.right    = d;
		b.left     = e;

		System.out.println(size(tree));
	}

	static int size(BinaryTree t) {
		return t == null ? 0 : 1 + size(t.left) + size(t.right);
	}
}

class BinaryTree <T> {

	T value;
	BinaryTree<T> left, right;

	BinaryTree(T v) {
		value = v;
	}
}
