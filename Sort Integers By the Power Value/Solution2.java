class Solution {
    
    private static class PowerInteger implements Comparable<PowerInteger> {
        
        int num;
        int power;
        
        public PowerInteger(int n) {
            num = n;
            power = 0;
            while (n != 1) {
                if (n % 2 == 0) {
                    power++;
                    n /= 2;
                } else {
                    power++;
                    n = n * 3 + 1;
                }
            }
        }
        
        
        public int compareTo(PowerInteger pi) {
            if (pi.power == power) {
                return num - pi.num;
            }
            return power - pi.power;
        }
    }
    
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<PowerInteger> powers = new PriorityQueue<>(hi - lo + 1);
        for (int i = lo; i <= hi; i++) {
            powers.add(new PowerInteger(i));
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = powers.poll().num;
        }
        
        return ans;
    }
}
