class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> ans = new ArrayList<String>();
        int n = pattern.length();
        for (int i = 0; i < words.length; i++) {
            char[] wordMap = new char[26];
            char[] permMap = new char[26];
            boolean works = true;
            for (int j = 0; j < n; j++) {
                char wordChar = words[i].charAt(j);
                char permChar = pattern.charAt(j);
                if (wordMap[wordChar - 'a'] != Character.MIN_VALUE) {
                    if (wordMap[wordChar - 'a'] != permChar) {
                        works = false;
                        break;
                    }
                }
                if (permMap[permChar - 'a'] != Character.MIN_VALUE) {
                    if (permMap[permChar - 'a'] != wordChar) {
                        works = false;
                        break;
                    }
                }
                wordMap[wordChar - 'a'] = permChar;
                permMap[permChar - 'a'] = wordChar;

            }
            if (works) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
