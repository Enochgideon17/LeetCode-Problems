class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                ans = mid;
                right = mid - 1;   // try to find smaller valid letter
            } else {
                left = mid + 1;
            }
        }

        // if no character is greater, wrap around
        return ans == -1 ? letters[0] : letters[ans];
    }
}
