class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            map[index] += 1;
        }
                
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == 1) {
                return i;
            }
        }
        
        
        
        return -1;
    }
}
