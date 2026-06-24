class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        int states = 2 * m;

        long[][] T = new long[states][states];

        for (int v = 0; v < m; v++) {

            int up = 2 * v + 1;
            int down = 2 * v;

            // (v, UP) -> (nv, DOWN) where nv < v
            for (int nv = 0; nv < v; nv++) {
                T[2 * nv][up] = 1;
            }

            // (v, DOWN) -> (nv, UP) where nv > v
            for (int nv = v + 1; nv < m; nv++) {
                T[2 * nv + 1][down] = 1;
            }
        }

        long[][] power = matrixPower(T, n - 1);

        long[] initial = new long[states];

        for (int v = 0; v < m; v++) {
            initial[2 * v] = 1;     // DOWN
            initial[2 * v + 1] = 1; // UP
        }

        long[] result = multiply(power, initial);

        long ans = 0;

        for (long x : result) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[][] matrixPower(long[][] base, long exp) {
        int n = base.length;

        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return result;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;

        long[] res = new long[n];

        for (int i = 0; i < n; i++) {

            long sum = 0;

            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;

                sum = (sum + A[i][j] * v[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }
}