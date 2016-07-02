import hanoi.*;

class TestSuite {

	public static void main(String[] args) {
		try {
			int[] nums = {1,2,2};
			Tower t = new Tower(nums);
			HanoiLoesungVerallgemeinert l = new HanoiLoesungVerallgemeinert(t);
			l.loese(3, 'a', 'b', 'c');
		}
		catch (TurmException e) {
			System.out.println(e);
		}
	}
}

class HanoiLoesungVerallgemeinert {

	Tower tower;

	HanoiLoesungVerallgemeinert(Tower t) {
		tower = t;
	}

	void loese (int n, char source, char aux, char target) throws TurmException {
		if (n > 0) {
			// move n-1 discs from source to aux
			loese(n -1, source, target, aux);
			// move 1 disc from source to target
			tower.move(source, target);
			// move n-1 disc from aux to target
			loese(n - 1, aux, source, target);
		}
	}
}
