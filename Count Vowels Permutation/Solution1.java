class Solution {
    public int countVowelPermutation(int n) {
        char[] vowels = new char[]{'a','e','i','o','u'};
        HashMap<Character, Integer> vowelMap = new HashMap<Character, Integer>();
        vowelMap.put('a', 0);
        vowelMap.put('e', 1);
        vowelMap.put('i', 2);
        vowelMap.put('o', 3);
        vowelMap.put('u', 4);
        
        long[][] dp = new long[5][n + 1];
        
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += (long) (recur(n, 1, vowels[i], vowels, vowelMap, dp) % (1E9 + 7));
            ans %= (long) (1E9 + 7);
        }
        
        return (int)(ans);
    }
    
    private long recur(int n, int size, char curChar, char[] vowels, HashMap<Character, Integer> vowelMap, long[][] dp) {
        if (size == n) {
            return 1;
        }
        if (dp[vowelMap.get(curChar)][size] != 0) return dp[vowelMap.get(curChar)][size];
        if (curChar == 'a') {
            dp[0][size] = (long) (recur(n, size + 1, 'e', vowels, vowelMap, dp) % (1E9 + 7));
            return dp[0][size];
        } else if (curChar == 'e') {
            dp[1][size] = (long) (((recur(n, size + 1, 'a', vowels, vowelMap, dp) % (1E9 + 7)) + (recur(n, size + 1, 'i', vowels, vowelMap, dp) % (1E9 + 7))) % (1E9 + 7));
            return dp[1][size];
        } else if (curChar == 'i') {
            
            int ans = 0;
            for (int i = 0; i < vowels.length; i++) {
                if (vowels[i] != 'i') {
                    ans += (long) (recur(n, size + 1, vowels[i], vowels, vowelMap, dp) % (1E9 + 7));
                    ans %= (long) (1E9 + 7);
                }
            }
            dp[2][size] = (long) (ans);
            return ans;
        } else if (curChar == 'o') {
            dp[3][size] = (long) (((recur(n, size + 1, 'i', vowels, vowelMap, dp) % (1E9 + 7)) + (recur(n, size + 1, 'u', vowels, vowelMap, dp) % (1E9 + 7))) % (1E9 + 7));
            return dp[3][size];
        } else {
            dp[4][size] = (long) (recur(n, size + 1, 'a', vowels, vowelMap, dp) % (1E9 + 7));
            return dp[4][size];
        }
    }
}
