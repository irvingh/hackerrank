import java.util.HashSet;
import java.util.Scanner;

public class GCDMatrix {
	public static void solve() {
	    Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    int m = in.nextInt();
	    int q = in.nextInt();
	    int[] a = new int[n];
	    for(int a_i=0; a_i < n; a_i++)
	        a[a_i] = in.nextInt();
	    int[] b = new int[m];
	    for(int b_i=0; b_i < m; b_i++)
	        b[b_i] = in.nextInt();
	    int[] r1 = new int[q];
	    int[] c1 = new int[q];
	    int[] r2 = new int[q];
	    int[] c2 = new int[q];
	    int minC = m+n, minR = m+n, maxC = 0, maxR = 0;
	    for (int a0 = 0; a0 < q; a0++) {
	        r1[a0] = in.nextInt();
	        if (r1[a0]<minR) minR = r1[a0];
	        c1[a0] = in.nextInt();
	        if (c1[a0]<minC) minC = c1[a0];
	        r2[a0] = in.nextInt();
	        if (r2[a0]>maxR) maxR = r2[a0];
	        c2[a0] = in.nextInt();
	        if (c2[a0]>maxC) maxC = c2[a0];
	    }
	    in.close();
	    int[][] g = new int[n][m]; //int[maxR-minR+1][maxC-minC+1];
	    for (int i=0; i<n; i++)
	        for (int j=0; j<m; j++)
	            g[i][j] = 0; // todo GCD.gcd(a[i], b[j]);
	    HashSet<Integer> hm = new HashSet<>();
	    for (int a0=0; a0<q; a0++) {
	        for (int i=r1[a0]; i<=r2[a0]; i++)
	            for (int j=c1[a0]; j<=c2[a0]; j++)
	                hm.add(g[i][j]);
	        System.out.println(hm.size());
	        hm.clear();
	    }
	}
}