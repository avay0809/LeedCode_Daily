class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        for (int len = k; len <= n; len++) {
            String result = "";
            for (int start = 0; start + len <= n; start++) { //trying all possible substr of len
                String temp = s.substring(start, start + len); //[start ... start+len)
                int ones = 0;
                for (char ch : temp.toCharArray()) {
                    ones += (ch == '1') ? 1 : 0;
                }
                // Keep it if it's beautiful and smaller than current best.
                if (ones == k) {
                    if (result.isEmpty() || temp.compareTo(result) < 0)
                        result = temp;
                }
            }

            //if we find result of len size, then it's smallest, no need to move to len++
            if (!result.isEmpty())
                return result;
        }
        return "";
    }
}