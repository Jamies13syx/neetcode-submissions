class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int zeros = 0;
        int zeroPos = -1;
        int product = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros++;
                zeroPos = i;
            }
            product *= nums[i];
        }
        if (zeros > 1) {
            return res;
        }
        else if (zeros == 1) {
            int p = 1;
            for (int i = 0; i < n; i++) {
                if (i != zeroPos) {
                    p *= nums[i];
                }
            }
            res[zeroPos] = p;
            return res;
        }
        else {
            for (int i = 0; i < n; i++) {
                res[i] = product / nums[i];
            }
        }
        return res;
    }
}  
