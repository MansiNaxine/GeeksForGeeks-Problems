class Solution {
    
    public int[] shortestPath(int V, int[][] edges, int src) {
        //using BfsTrvaersal
        List<List<Integer>> adjancyList = new ArrayList<>();
        for(int i = 0 ; i < V; i++) {
            adjancyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjancyList.get(u).add(v);
            adjancyList.get(v).add(u);
        }
        
        int[] distArr = new int[V];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[src] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        
        while(!que.isEmpty()) {
            int node = que.remove();
            
            for(int num : adjancyList.get(node)) {
                if(distArr[node] + 1 < distArr[num]) {
                    distArr[num] = distArr[node] + 1;
                    que.add(num);
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(distArr[i] == Integer.MAX_VALUE) distArr[i] = -1;
        }
        return distArr;
    }
    
    // public int[] dfsTraversal(int V, int[][] edges, int src) {
    //     //using DfsTrvaersal
    //     //Create Adjancy List
    //     List<List<Integer>> adjancyList = new ArrayList<>();
    //     for(int i = 0 ; i < V; i++) {
    //         adjancyList.add(new ArrayList<>());
    //     }
        
    //     for(int i = 0; i < edges.length; i++) {
    //         int u = edges[i][0];
    //         int v = edges[i][1];
    //         adjancyList.get(u).add(v);
    //         adjancyList.get(v).add(u);
    //     }
        
    //     int[] distArr = new int[V];
    //     Arrays.fill(distArr, Integer.MAX_VALUE);
    //     distArr[src] = 0;
    //     findShortestDist(distArr, adjancyList, src);
    //     for(int i = 0; i < V; i++) {
    //         if(distArr[i] == Integer.MAX_VALUE) distArr[i] = -1;
    //     }
    //     return distArr;
    // }
    
    // public void findShortestDist(int[] distArr, List<List<Integer>> adjancyList, int root) {
    //     for(int num : adjancyList.get(root)) {
    //         if(distArr[root] + 1 < distArr[num]) {
    //             distArr[num] = distArr[root] + 1;
    //             findShortestDist(distArr, adjancyList, num);
    //         }
    //     }
    // }
}
