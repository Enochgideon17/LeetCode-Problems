class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1,water=0,leftmax=0,rightmax=0;
        while(left<right){
            if(height[left]<height[right]){
                leftmax=Math.max(leftmax,height[left]);
                water+=leftmax-height[left];
                left++;
            }
            else{
                rightmax=Math.max(rightmax,height[right]);
                water+=rightmax-height[right];
                right--;
            }
        }
        return water;
    }
}