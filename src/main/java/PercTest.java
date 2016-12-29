import java.util.Arrays;

public class PercTest {

	public static void main(String[] args) {
		int n = 5;
		Percolation perc = new Percolation(n);
//		System.out.println(Arrays.toString(perc.getParentArray()));
		System.out.println(Arrays.toString(perc.getStateArray()));
//		System.out.println(perc.numberOfOpenSites());
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 1; j <= 5; j++) {
//				System.out.print("row: " + i + " col: " + j + " parent val: " + perc.getparentValue(i, j));
//				System.out.println();
//			}
//		}
	}

}
