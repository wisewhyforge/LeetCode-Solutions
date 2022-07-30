class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> ans = new ArrayList<String>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words2.length; i++) {
            char[] map = new char[26];
            for (int j = 0; j < words2[i].length(); j++) {
                map[words2[i].charAt(j) - 'a']++;
            }
            
            set.add(new String(map));
        }
        
        char[][] bMap = new char[set.size()][26];
        
        for (int i = 0; i < bMap.length; i++) {
            for (int j = 0; j < words2[i].length(); j++) {
                bMap[i][words2[i].charAt(j) - 'a']++;
            }
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (isUniversal(words1[i], bMap)) {
                ans.add(words1[i]);
            }
        }
        return ans;
    }
    
    private boolean isUniversal(String s, char[][] bMap) {
        
        char[] aMap = new char[26];
        for (int i = 0; i < s.length(); i++) {
            aMap[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < bMap.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (aMap[j] < bMap[i][j]) {
                    return false;
                }
            }
            
        }
        return true;
    }
}
