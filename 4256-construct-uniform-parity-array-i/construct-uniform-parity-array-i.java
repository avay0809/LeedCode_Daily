class Solution {
    public boolean uniformArray(int[] nums1) {
        int minEl = Integer.MAX_VALUE;
        for (int num : nums1) {
            minEl = Math.min(minEl, num);
        }

        if (minEl % 2 == 1) {   // odd - then we can convert all even to odd
            return true;        // all nums2 will be odd
        }

       
        return true;            // all nums2 will be even
    }
}