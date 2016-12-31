import java.util.Arrays;

public class PercTest {

	public static void main(String[] args) {
		int n = 5;
		Percolation perc = new Percolation(n);
		System.out.println(perc.isOpen(1, 1));
		perc.open(1, 2);
		perc.open(2, 1);
		perc.open(2, 2);
		perc.open(2, 3);
		perc.open(3, 2);
		System.out.println(perc.numberOfOpenSites());
//		System.out.println(perc.parentArray.connected(6, 1));
//		System.out.println(perc.parentArray.connected(6, 5));
//		System.out.println(perc.parentArray.connected(6, 7));
//		System.out.println(perc.parentArray.connected(6, 11));
	}

}
