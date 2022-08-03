class MyCalendar {
    
    private static class Range implements Comparable<Range>{
        
        int start;
        int end;
        
        public Range(int s, int e) {
            start = s;
            end = e;
        }
        
        
        public int compareTo(Range r) {
            if (this.equals(r)) {
                return 0;
            }
            return this.start - r.start;
        }
        
        public boolean equals(Object o) {
            if (o != null && this.getClass() == o.getClass()) {
                Range r = (Range) o;
                if ((start <= r.start && r.start < end) || (r.end < end && r.end > start) || (r.start <= start && start < r.end) || (end > r.start && end < r.end)) {
                    return true;
                }
            }
            return false;
        }
        
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
    
    SortedSet s;

    public MyCalendar() {
        s = new TreeSet();
    }
    
    public boolean book(int start, int end) {
        Range r = new Range(start, end);
        if (s.contains(r)) {
            return false;
        } else {
            s.add(r);
            return true;
        }

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
