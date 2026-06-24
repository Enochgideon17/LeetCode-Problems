class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] mergeNums = new int[m + n];
        
        System.arraycopy(nums1, 0, mergeNums, 0, m);
        System.arraycopy(nums2, 0, mergeNums, m, n);
        
        Arrays.sort(mergeNums);
        
        if ((m + n) % 2 != 0) {
            return mergeNums[(m + n) / 2];
        } else {
            int mid1 = mergeNums[(m + n) / 2];
            int mid2 = mergeNums[(m + n) / 2 - 1];
            return (mid1 + mid2) / 2.0;
        }
    }
}