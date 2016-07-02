import hanoi.*;
import java.util.*;

class TestSuite {

	public static void main(String[] args) {
		try {
			System.out.println("Input for this program is expected on two lines:");
			System.out.println("\t1) The number of discs for the problem.");
			System.out.println("\t2) A series of space separated numbers in ascending order, signifying the start tower.");
			// read input
			Scanner scan = new Scanner(System.in);
			// to store discs
			int[] nums = new int[scan.nextInt()];
			// to store unique discs
			HashSet<Integer> set = new HashSet<Integer>();
			// populate array from input
			for (int i = 0; i < nums.length; i++) {
				int x = scan.nextInt();
				nums[i] = x;
				set.add(x);
			}
			// number of unique elems in nums
			int n = set.size();
			// init tower & solution objects
			Tower t = new Tower(nums);
			HanoiLoesungVerallgemeinert l = new HanoiLoesungVerallgemeinert(t);
			// start solution
			l.loese(n, 'a', 'b', 'c');
			System.out.printf("Solved in %d moves!\n", t.moves());
		}
		catch (TurmException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

// GENERAL SOLUTION
// ---------------------
// Solve the Tower of Hanoi problem optimally, where repetitions of
// discs are permitted/
//
class HanoiLoesungVerallgemeinert {

	Tower tower;

	HanoiLoesungVerallgemeinert(Tower t) {
		tower = t;
	}

	// LOESE | Solve the problem optimally, using recursion
	//
	void loese (int n, char source, char aux, char target) {
		// base
		if (n > 0) {
			// move n-1 discs from source to aux
			loese(n - 1, source, target, aux);

			try {
				// move 1 disc from source to target
				int top = tower.move(source, target);
				// while the next discs are the same size
				while (!tower.isEmpty(source) && top == tower.top(source)) {
					// repeat the move
					tower.move(source, target);
				}
			}
			catch (TurmException e) {
				System.out.println(e);
			}
			// move n-1 disc from aux to target
			loese(n - 1, aux, source, target);
		}
	}
}
