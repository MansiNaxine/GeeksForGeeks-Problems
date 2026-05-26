class Solution {
    public int minSteps(int[] arr, int start, int end) {
        
        int n = arr.length;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, start));
        int visited[] = new int[1000];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;
        
        while(!que.isEmpty()) {
            Pair inner = que.remove();
            int currStep = inner.step;
            int currNode = inner.node;
            
            if(currNode == end) return currStep;
            
            for(int i = 0; i < n; i++) {
                int newValue = (currNode * arr[i])%1000;
                int newStep = currStep + 1;
                if(newStep < visited[newValue]) {
                    visited[newValue] = newStep;
                    if(newValue == end) return newStep;
                    que.add(new Pair(newStep, newValue));
                }
                
                
            }
        }
        
        return -1;
        
    }
}

class Pair {
    int step;
    int node;
    
    Pair(int step, int node) {
        this.step = step;
        this.node = node;
    }
}