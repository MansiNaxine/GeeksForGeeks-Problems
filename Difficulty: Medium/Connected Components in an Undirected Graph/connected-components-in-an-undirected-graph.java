class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        
        //First i hv to create an adjacencyList
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            
        }
        
        int[] visited = new int[V];
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                ArrayList<Integer> currList = new ArrayList<>();
                dfsTraversal(adjacencyList, visited, currList, i);
                answer.add(new ArrayList<>(currList));
            }
            
        }
        
        return answer;
    }
    
    public void dfsTraversal(List<List<Integer>> adjacencyList, int[] visited, ArrayList<Integer> currList, int root) {
        
        currList.add(root);
        visited[root] = 1;
        
        for(int element : adjacencyList.get(root)) {
            if(visited[element] == 0) {
                dfsTraversal(adjacencyList, visited, currList, element);
            }
        }
    }
}