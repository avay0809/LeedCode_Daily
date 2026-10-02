class Solution {

    public long[] resultArray(int[] nums, int k) {

        // result[r] = total subarrays
        // jinka product % k = r
        long[] result = new long[k];

        // dp[r] = current position par end hone wale
        // subarrays jinka product % k = r
        long[] dp = new long[k];

        for (int num : nums) {

            int rem = num % k;

            // Current number ke liye new DP array
            long[] newDp = new long[k];

            // 1. Sirf current element se ek subarray
            newDp[rem]++;

            // 2. Previous subarrays ko current number ke saath extend karo
            for (int r = 0; r < k; r++) {

                if (dp[r] > 0) {

                    int newRem = (r * rem) % k;

                    newDp[newRem] += dp[r];
                }
            }

            // DP update
            dp = newDp;

            // Current index par end hone wale
            // saare subarrays ko final answer mein add karo
            for (int r = 0; r < k; r++) {

                result[r] += dp[r];
            }
        }

        return result;
    }
}