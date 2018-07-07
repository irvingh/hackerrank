public class Matrix2DPath {
    Matrix2DPath() {
        int n = 4;
        int m = 5;
        int[][] A = {{1, 2, 3, -1, -2}, {-5, -8, -1, 2, -150}, {1, 2, 3, -250, 100}, {1, 1, 1, 1, 20}};
        int result = matrixLand(A, n, m);
        System.out.println(result);
    }

    static int matrixLand(int[][] A, int y, int x) {
        int[][] tc = new int[y][x];
        tc[0][0] = A[0][0];
        for (int j=1; j<x; j++)
           tc[0][j] = tc[0][j-1] + A[0][j];
        for (int j=x-2; j>=0; j--)
           tc[0][j] = Math.max(tc[0][j], tc[0][j] + A[0][j+1]);
        //for (int i=1; i<y; i++)
        //    tc[i][0] = tc[i-1][0] + A[i][0];
        for (int i=1; i<y; i++) {
            for (int j=0; j<x; j++) {
                if (j==0)
                    tc[i][j] = tc[i-1][j] + A[i][j];
                else
                    tc[i][j] = Math.max(tc[i-1][j], tc[i][j-1]) + A[i][j];
                A[i][j] = 0;
            }
            for (int j=x-2; j>=0; j--) {
                tc[i][j] = Math.max(tc[i][j], Math.max(tc[i][j]+A[i][j+1], tc[i][j+1] + A[i][j]));
            }
        }
        for (int i=0; i<y; i++) {
            for (int j=0; j<x; j++)
                System.out.print(tc[i][j]+"\t");
            System.out.println("");
        }
        return tc[y-1][x-1];
    }
}
