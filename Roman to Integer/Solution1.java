class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("M", 1000);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int i = 0;
        
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String candidate = s.substring(i, i + 2);
                if (map.containsKey(candidate)) {
                    ans += map.get(candidate);
                    i += 2;
                } else {
                    ans += map.get(s.charAt(i) + "");
                    i++;
                }
            } else {
                ans += map.get(s.charAt(i) + "");
                i++;
            }
        }
        
        return ans;
    }
}
