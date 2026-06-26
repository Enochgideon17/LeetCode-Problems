class Solution {
    public void sortColors(int[] nums) {
        int left = 0;

        // Move all 0s to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }

        int right = nums.length - 1;

        // Move all 2s to the back
        for (int i = nums.length - 1; i >= left; i--) {
            if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }
}
