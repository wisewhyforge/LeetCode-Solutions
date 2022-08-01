class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }        
        int maxLength = 1;
        String ans = "" + s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.length() - i <= maxLength) {
                return ans;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 <= maxLength) {
                    continue;
                }
                String candidate = s.substring(i,j + 1);
                if (isPalindrome(candidate)) {
                    int length = candidate.length();
                    if (length > maxLength) {
                        ans = candidate;
                        maxLength = length;
                    }
                }
            }
        }
        
        return ans;
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
