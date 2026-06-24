class Solution(object):
    def twoSum(self, nums, t):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        m={}
        for i,n in enumerate (nums):
            c=t-n
            if c in m:
                return [m[c],i]
            m[n]=i