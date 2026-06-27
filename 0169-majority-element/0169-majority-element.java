class Solution {
    public int majorityElement(int[] nums) {
        int count=0,candit=0;
        for(int n:nums){
            if(count==0)
                candit=n;
            count+=(candit==n)?1:-1;
        }
        return candit;
    }
}