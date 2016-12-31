import java.util.Arrays;

public class PercTest {

	public static void main(String[] args) {
		int n = 5;
		Percolation perc = new Percolation(n);
//		System.out.println(Arrays.toString(perc.getStateArray()));
		System.out.println(perc.isOpen(1, 1));
		perc.open(1, 1);
		perc.open(1, 2);
		System.out.println(perc.isOpen(1, 1));
		System.out.println(perc.numberOfOpenSites());
		System.out.println(perc.parentArray.connected(0, 1));
		System.out.println(perc.parentArray.connected(0, 5));
		perc.open(2, 1);
		System.out.println(perc.parentArray.connected(0, 5));
	}

}
