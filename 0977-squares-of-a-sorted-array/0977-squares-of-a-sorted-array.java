class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0, right=nums.length-1;
        int pos=nums.length-1;
        int res[]=new int[nums.length];
        while(left<=right){
            if (Math.abs(nums[left])>(nums[right])){
                res[pos--]=nums[left]*nums[left];
                left++;
            }
            else{
                res[pos--]=nums[right]*nums[right];
                right--;
            }
        }

        return res;
    }
}