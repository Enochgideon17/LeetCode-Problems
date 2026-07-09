class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    private int atmost(int [] nums,int k){
        int left=0,right=0,count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(right=0;right<nums.length;right++){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}