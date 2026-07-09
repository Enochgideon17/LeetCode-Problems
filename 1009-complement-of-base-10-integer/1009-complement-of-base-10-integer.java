class Solution {
    public int bitwiseComplement(int n) {
        
        // Special case
        if (n == 0) return 1;

        int mask = 0;
        int temp = n;

        // Create mask with all 1s
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        // XOR with mask to flip bits
        return mask ^ n;
    }
}