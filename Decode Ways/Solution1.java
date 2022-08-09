class Solution {
    public int numDecodings(String s) {
        HashMap<String, Character> map = new HashMap<String, Character>();
        for (int i = 1; i <= 26; i++) {
            map.put(i + "", (Character)((char) (64 + i)));
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        //System.out.println(map);
        return recur(s, 0, map, dp);
    }
    
    private int recur(String s, int i, HashMap<String, Character> map, int[] dp) {
        if (i >= s.length()) {
            return 1;
        }
        if (s.charAt(i) - '0' == 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        if (i < s.length() - 1) {
            String add = s.substring(i, i + 2);
            //System.out.println(add);
            if (map.containsKey(add)) {
                //System.out.println("Yes");
                dp[i] = recur(s, i + 1, map, dp) + recur(s, i + 2, map, dp);
                return dp[i];
            } 
        } 
        dp[i] = recur(s, i + 1, map, dp);
        return dp[i];
        
    }
}
