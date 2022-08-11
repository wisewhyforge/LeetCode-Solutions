class Solution {
    
    static class Pair  {
        
        int start;
        int end;
        
        public Pair(int s, int e) {
            start = s;
            end = e;
        }
        
        public boolean overlaps(Pair p) {
            if (start <= p.start && end >= p.start) {
                return true;
            }
            if (start <= p.end && end >= p.end) {
                return true;
            }
            if (p.start <= start && p.end >= start) {
                return true;
            }
            if (p.end <= end && p.end >= end) {
                return true;
            }
            
            return false;
        }
        
        public int hashCode() {
            return (start * 31) + (end * 31 * 31);
        }
        
        public boolean equals(Object o) {
            if (o != null && this.getClass() == o.getClass()) {
                Pair p = (Pair) o;
                if (p.start == start && p.end == end) {
                    return true;
                }
                return false;
            }
            return false;
        }
        
        public boolean merge(Pair p) {
            
            if (overlaps(p)) {
                start = Math.min(p.start, start);
                end = Math.max(p.end, end);
                return true;
            }
            
            return false;
        }
        
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
    
    public int[][] merge(int[][] intervals) {
        ArrayList<Pair> ans = new ArrayList<Pair>();
        for (int i = 0; i < intervals.length; i++) {
            Pair p = new Pair(intervals[i][0], intervals[i][1]);
            boolean paired = false;
            for (int j = 0; j < ans.size(); j++) {
                if (ans.get(j).overlaps(p)) {
                    ans.get(j).merge(p);
                    paired = true;
                } 
            }
            
            if (!paired) {
                ans.add(p);
            }
        }
        
        
        
        HashSet<Pair> set = new HashSet<Pair>();
        for (Pair p : ans) {
            set.add(p);
        }
        int[][] pairs = new int[set.size()][2];
        int index = 0;
        for (Pair p : set) {
            pairs[index][0] = p.start;
            pairs[index][1] = p.end;
            index++;
        }
        if(pairs.length == intervals.length) {
            return pairs;
        }
        pairs = merge(pairs);
        return pairs;
    }
    
    public int[][] mergeCopy(int[][] intervals) {
        ArrayList<Pair> ans = new ArrayList<Pair>();
        for (int i = 0; i < intervals.length; i++) {
            Pair p = new Pair(intervals[i][0], intervals[i][1]);
            boolean paired = false;
            for (int j = 0; j < ans.size(); j++) {
                if (ans.get(j).overlaps(p)) {
                    ans.get(j).merge(p);
                    paired = true;
                } 
            }
            
            if (!paired) {
                ans.add(p);
            }
        }
        
        
        
        HashSet<Pair> set = new HashSet<Pair>();
        for (Pair p : ans) {
            set.add(p);
        }
        int[][] pairs = new int[set.size()][2];
        int index = 0;
        for (Pair p : set) {
            pairs[index][0] = p.start;
            pairs[index][1] = p.end;
            index++;
        }
        return pairs;
    }
}
