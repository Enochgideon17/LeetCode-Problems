class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] +
                    (nums[i] == target ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();

        int id = 1;

        for (int x : sorted) {
            if (!rank.containsKey(x)) {
                rank.put(x, id++);
            }
        }

        Fenwick bit = new Fenwick(id);

        long ans = 0;

        for (int p : prefix) {

            int compressed = rank.get(p);

            ans += bit.query(compressed - 1);

            bit.update(compressed, 1);
        }

        return ans;
    }
}