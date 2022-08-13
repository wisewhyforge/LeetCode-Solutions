class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        int wordLength = words[0].length();
        int substringLength = words.length * wordLength;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i <= s.length() - substringLength; i++) {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            boolean isBad = false;
            for (int j = i; j < i + substringLength; j += wordLength) {
                
                String substring = s.substring(j, j + wordLength);
                if (!map.containsKey(substring)) {
                    isBad = true;
                    break;
                } else {
                    if (!curMap.containsKey(substring)) {
                        curMap.put(substring, 1);
                    } else {
                        curMap.put(substring, curMap.get(substring) + 1);
                    }
                }
            }
            if (isBad) {
                continue;
            } else {
                if (curMap.equals(map)) {
                    ans.add(i);
                }
            }
        }
        
        return ans;
    }
}
