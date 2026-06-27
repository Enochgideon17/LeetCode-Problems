class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num,
                    freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        for (long start : freq.keySet()) {

            if (start == 1) {
                int cnt = freq.get(1L);

                if (cnt % 2 == 0) cnt--;

                ans = Math.max(ans, cnt);
                continue;
            }

            long cur = start;
            int length = 0;

            while (true) {

                int cnt = freq.getOrDefault(cur, 0);

                if (cnt >= 2) {
                    length += 2;
                    cur = cur * cur;
                }
                else if (cnt == 1) {
                    length += 1;
                    break;
                }
                else {
                    length--;
                    break;
                }
            }

            ans = Math.max(ans, length);
        }

        return ans;
    }
}