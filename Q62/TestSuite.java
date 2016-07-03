import linkedList.*;
import java.util.*;

class TestSuite {

	public static void main(String[] args) {
		LinkedQueue<Integer> queue = randomQueue(10);
		System.out.println("\nUnsorted queue:");
		System.out.println(queue);
		queue = RadixSort.sort(queue);
		System.out.println("\nSorted queue:");
		System.out.println(queue);
	}

	// RANDOM QUEUE | Return a queue of random Integers.
	//
	static LinkedQueue<Integer> randomQueue(int size) {
		// generate random numbers between -10k & 10k
		Iterator iter = new Random().ints(10,-10000,10000).iterator();
		Integer[] nums = new Integer[size];
		for (int i = 0; i < nums.length; i++)
			nums[i] = (Integer) iter.next();

		return new LinkedQueue<Integer>(nums);
	}
}

// RADIX SORT | Implementation of the Radix Sort Algorithm using LinkedQueue.
// 						| The input queue should contain Integer elements. The input
// 						| queue will be processed four times, one for each byte of a
// 						| 4-Byte Integer element. After the fourth pass, the queue will
// 						| be sorted.
//
class RadixSort {

	// SORT | Return sorted queue.
	//
	static LinkedQueue<Integer> sort(LinkedQueue<Integer> queue) {
		// for each byte
		for (int i = 0; i < 4; i++)
			// perform a pass
			queue = pass(queue, i);

		return queue;
	}

	// PASS | Sort queue in relation to b'th byte of Integer elements. On the
	// 			| first three passes this function returns a partially sorted queue.
	// 			| On fourth pass the sorted queue is return, however in order to
	// 			| sort negative & positive elements correctly, the two halves of
	// 			| the list are swapped & then returned.
	//
	static private LinkedQueue<Integer> pass(LinkedQueue<Integer> queue, int b) {
		// init array with 256 empty queues
		List<LinkedQueue<Integer>> arr = new ArrayList<LinkedQueue<Integer>>(256);
		for (int i = 0; i < 256; i++) arr.add(new LinkedQueue<Integer>());
		// for each element in queue
		for (Node<Integer> n : queue) {
			// shift b bytes & mask upper 3 bytes
			int lowerByte = (n.value >>> b * 8) & 255;
			// append to queue at arr[lowerByte]
			arr.get(lowerByte).append(n.value);
		}

		// combine arr queues
		LinkedQueue<Integer> temp = new LinkedQueue<Integer>();

		// if last pass
		if (b == 3)
			// second half, then first half
			for (int i = 0; i < 256; i++)
				// i = 128 ... 255, 0 ... 127
				temp.append(arr.get((i+128)%256));
		else
			// 0 ... 255
			for (LinkedQueue<Integer> q : arr) temp.append(q);

		return temp;
	}
}
