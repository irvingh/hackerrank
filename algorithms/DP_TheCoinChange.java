public class DP_TheCoinChange {
	int numCoins = 4, m = 3;
	int[] coins = {0, 8, 3, 1, 2};
	long[][] table = new long[numCoins+1][m+1];
	long[][] calculated = new long[numCoins+1][m+1];
	public DP_TheCoinChange() {
		System.out.println(solve(1, 3));
	}
	public long solve(int i, int make) {
		if (make<0) return 0;
		if (make==0) return 1;
		if (i>numCoins) return 0;
		if (calculated[i][make]==0) {
			table[i][make] = solve(i, make - coins[i]) + solve(i+1, make);
			calculated[i][make] = 1;
		}
		return table[i][make];
	}
}