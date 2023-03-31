public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
		first = f;
		rest = r;
    }

    public int size() {
		if (this.rest == null) {
	    	return 1;
		}
		return 1 + this.rest.size();
    }

    public int iterativeSize() {
		IntList tmp = this;
		int ans = 0;
		while (tmp != null) {
	    	ans++;
	    	tmp = tmp.rest;
		}
		return ans;
    }

    public int get(int i) {
		int tmp = 0;
		IntList Ltmp = this;
		while (tmp < i) {
	    	Ltmp = Ltmp.rest;
	    	tmp++;
		}
		return Ltmp.first;
    }

	public void skippify() {
		IntList p = this;
		int n = 1;
		while (p != null) {
			IntList next = p.rest;
			for (int i = 0; i < n; i++) {
				if (next == null) {
					break;
				}
				next = next.rest;
			}
			p.rest = next;
			p = p.rest;
			n++;
		}
	}

	public static void removeDuplicates(IntList p) {
		if (p == null) {
			return ;
		}

		IntList current = p.rest;
		IntList previous = p;
		while (current != null) {
			if (previous.first == current.first) {
				previous.rest = current.rest;
			} else {
				previous = current;
			}
			current = current.rest;
		}
	}

    public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		int len1 = L.size();
		int len2 = L.iterativeSize();
		int out = L.get(1);

		System.out.println("length1: " + len1);
		System.out.println("length2: " + len2);
		System.out.println("out: " + out);

		IntList Ltest = null;
		for (int i = 1; i < 10; i++) {
			Ltest = new IntList(i, Ltest);
		}
		Ltest.skippify();

		IntList Ltt = new IntList(3, null);
		Ltt = new IntList(2, Ltt);
		Ltt = new IntList(2, Ltt);
		Ltt = new IntList(2, Ltt);
		Ltt = new IntList(1, Ltt);
		removeDuplicates(Ltt);
    }
}
