// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        
        //Create Adjancy List
        List<List<Pair>> adjancyList = new ArrayList<>();
        for(int i = 0 ; i < V; i++) {
            adjancyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int e = edges[i][2];
            Pair p = new Pair(v, e);
            adjancyList.get(u).add(p);
        }
        
        int[] distArr = new int[V];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[0] = 0;
        findShortestDist(distArr, adjancyList, 0);
        for(int i = 0; i < V; i++) {
            if(distArr[i] == Integer.MAX_VALUE) distArr[i] = -1;
        }
        return distArr;
    }
    
    public void findShortestDist(int[] distArr, List<List<Pair>> adjancyList, int root) {
        for(Pair num : adjancyList.get(root)) {
            int weight = num.edge;
            if(distArr[root] + weight < distArr[num.node]) {
                distArr[num.node] = distArr[root] + weight;
                findShortestDist(distArr, adjancyList, num.node);
            }
        }
    }
}

class Pair {
    
    int node;
    int edge;
    Pair(int node, int edge) {
        this.node = node;
        this.edge = edge;
    }
}