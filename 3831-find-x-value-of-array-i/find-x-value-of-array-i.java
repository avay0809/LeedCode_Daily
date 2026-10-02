class Solution {

    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = current position par end hone wale
        // subarrays ki count jinka product % k = r
        long[] dp = new long[k];

        for (int x : nums) {

            long[] newDp = new long[k];

            // Previous subarrays ko x ke saath extend karo
            for (int r = 0; r < k; r++) {

                int newRemainder = (int) ((1L * r * x) % k);

                newDp[newRemainder] += dp[r];
            }

            // Sirf x se ek naya subarray
            newDp[x % k]++;

            // Answer mein add karo
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            // DP update
            dp = newDp;
        }

        return ans;
    }
}