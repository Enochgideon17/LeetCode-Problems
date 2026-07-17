class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {

            int index = 0;

            for (int j = n - 1; j >= 0; j--) {

                if (image[i][j] == 0) {
                    ans[i][index] = 1;
                } else {
                    ans[i][index] = 0;
                }

                index++;
            }
        }

        return ans;
    }
}