class Solution {
    public int edgeScore(int[] edges) {
        
        int sum = 0;
        for (int i = 2; i < 42; i++) {
            sum += i;
        }
        //System.out.println(sum);
        HashMap<Integer, Long> scoreMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!scoreMap.containsKey(edges[i])) {
                scoreMap.put(edges[i], (long) i);
            } else {
                scoreMap.put(edges[i], i + scoreMap.get(edges[i]).longValue());
            }
        }
        

        return findIndex(edges, scoreMap);
    }
    
    private int findIndex(int[] edges, HashMap<Integer, Long> scoreMap) {
        long max = 0;
        int maxIndex = edges.length;
        for (Integer node : scoreMap.keySet()) {
            long score = scoreMap.get(node);
            //System.out.println(node + " " + score);
            if (score > max) {
                max = score;
                maxIndex = node.intValue();
            } else if (score == max) {
                maxIndex = Math.min(node.intValue(), maxIndex);
            }
        }
        
        return maxIndex;
    }
}
