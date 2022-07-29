class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> ans = new ArrayList<String>();
        int n = pattern.length();
        for (int i = 0; i < words.length; i++) {
            //char[] wordMap = new char[26];
            //char[] permMap = new char[26];
            HashMap<Character, Character> hash1 = new HashMap<Character, Character>();
            HashMap<Character, Character> hash2 = new HashMap<Character, Character>();
            boolean works = true;
            for (int j = 0; j < n; j++) {
                char wordChar = words[i].charAt(j);
                char permChar = pattern.charAt(j);
                if (hash1.get(wordChar) != null) {
                    if (hash1.get(wordChar) != permChar) {
                        works = false;
                        break;
                    }
                }
                if (hash2.get(permChar) != null) {
                    if (hash2.get(permChar) != wordChar) {
                        works = false;
                        break;
                    }
                }
                hash1.put(wordChar, permChar);
                hash2.put(permChar, wordChar);
                //wordMap[wordChar - 'a'] = permChar;
                //permMap[permChar - 'a'] = wordChar;
            }
            if (works) {
                ans.add(words[i]);
            }
            if (i == 1) {
                //System.out.println(Arrays.toString(wordMap));
                //System.out.println(Arrays.toString(permMap));
                //System.out.println(hash1);
                //System.out.println(hash2);
            }
        }
        return ans;
    }
}
