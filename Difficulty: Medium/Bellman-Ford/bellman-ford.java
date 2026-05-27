// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        
        //Create an adjancyList
        // List<List<List<Integer>>> adjancyList = new ArrayList<>();
        // for(int i = 0; i < V; i++) {
        //     adjancyList.add(new ArrayList<>());
        // }
        
        // for(int i = 0; i < edges.length; i++) {
        //     int u = edges[i][0];
        //     int v = edges[i][1];
        //     int e = edges[i][2];
            
        //     List<Integer> currList = new ArrayList<>();
        //     currList.add(v);
        //     currList.add(e);
            
        //     adjancyList.get(u).add(new ArrayList<>(currList));
        // }
        
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e8);
        distance[src] = 0;
        
        //Iterate till V-1 as per Bellman Ford's Algorithm
        for(int i = 0; i < V - 1; i++) {
            for(int j = 0; j < edges.length; j++) {
                int root = edges[j][0];
                int node = edges[j][1];
                int weight = edges[j][2];
                if(distance[root] != (int)1e8 && distance[root] + weight < distance[node]) {
                    distance[node] = distance[root] + weight;
                }
            }
        }
        
        for(int j = 0; j < edges.length; j++) {
            int root = edges[j][0];
            int node = edges[j][1];
            int weight = edges[j][2];
            if(distance[root] != (int)1e8 && distance[root] + weight < distance[node]) {
                return new int[]{-1};
            }
        }
        
        
        
        // for(int i = 0 ; i < V; i++) {
        //     if(distance[src] < 0) return new int[]{-1};
        //     if(distance[i] > 100000000 || distance[i] < -100000000) {
        //         distance[i] = 100000000;
        //     }
        // }
        
        return distance;
        
    }
}
