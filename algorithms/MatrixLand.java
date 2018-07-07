public class MatrixLand {
    public MatrixLand() {
        int[][] a = {{0, 0, 0, 0, 0, 0, 0}, {0, 1, 2, 3, -1, -2, 0}, {0, -5, -8, -1, 2, -150, 0}, {0, 1, 2, 3, -250, 100, 0}, {0, 1, 1, 1, 1, 20, 0}, {0, 0, 0, 0, 0, 0, 0}};
        solution(a, 4, 5);
    }

    private void solution(int[][] a, int n, int m) {
        int[] d = new int[m+2];
        int[] msl = new int[m+2];
        int[] msr = new int[m+2];
        int[][] dp = new int[n+2][m+2];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                msl[j] = Math.max(msl[j-1] + a[i][j], 0);
            for (int j = m; 0 < j; j--)
                msr[j] = Math.max(msr[j+1] + a[i][j],0);

            d[1] = dp[i-1][1] + a[i][1];
            dp[i][1] = d[1] + msr[2];
            for (int j = 2; j <= m; j++) {
                d[j] = Math.max(d[j-1] + a[i][j], dp[i-1][j] + a[i][j] + msl[j-1]);
                dp[i][j] = d[j] + msr[j + 1];
            }

            d[m] = dp[i-1][m] + a[i][m];
            dp[i][m] = Math.max(dp[i][m], d[m] + msl[m - 1]);
            for (int j = m - 1; 0 < j ; j--) {
                d[j] = Math.max(d[j+1] + a[i][j], dp[i-1][j] + a[i][j] + msr[j+1]);
                dp[i][j] = Math.max(dp[i][j], d[j] + msl[j - 1]);
            }
        }

        int ans = dp[n][1];
        for (int i = 2; i <= m; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }


 }