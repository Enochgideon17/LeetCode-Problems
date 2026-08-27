class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Try to match target from left to right.
        for (int i = 0; i < n; i++) {
            int cur = target.charAt(i) - 'a';

            // We can use target[i]
            if (cnt[cur] > 0) {
                cnt[cur]--;
                continue;
            }

            // We cannot use target[i].
            // First, try making THIS position larger.
            String result = buildGreater(target, i, cnt);
            if (result != null) {
                return result;
            }

            // Otherwise, backtrack and increase an earlier position.
            for (int j = i - 1; j >= 0; j--) {
                cnt[target.charAt(j) - 'a']++;

                result = buildGreater(target, j, cnt);

                if (result != null) {
                    return result;
                }
            }

            return "";
        }

        // target itself can be formed.
        // We still need a strictly greater permutation.
        for (int i = n - 1; i >= 0; i--) {
            cnt[target.charAt(i) - 'a']++;

            String result = buildGreater(target, i, cnt);

            if (result != null) {
                return result;
            }
        }

        return "";
    }

    private String buildGreater(String target, int pos, int[] cnt) {
        int cur = target.charAt(pos) - 'a';

        // Find the smallest available character
        // that is strictly greater than target[pos].
        for (int c = cur + 1; c < 26; c++) {
            if (cnt[c] == 0) {
                continue;
            }

            StringBuilder ans = new StringBuilder();

            // Keep prefix unchanged.
            ans.append(target, 0, pos);

            // Make this position larger.
            ans.append((char) ('a' + c));
            cnt[c]--;

            // Put remaining characters in sorted order.
            for (int x = 0; x < 26; x++) {
                while (cnt[x] > 0) {
                    ans.append((char) ('a' + x));
                    cnt[x]--;
                }
            }

            return ans.toString();
        }

        return null;
    }
}