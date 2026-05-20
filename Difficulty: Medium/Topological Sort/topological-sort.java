class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        //For Topological Sort
        //First create an adjancyList
        List<List<Integer>> adjancyList = new ArrayList<>();
        for(int i = 0 ; i < V; i++) {
            adjancyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjancyList.get(u).add(v);
            
        }
        
        //Apply dfs traversal
        int visited[] = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                dfsTraversal(edges, adjancyList, visited, i, st);
            }
        }
        
        ArrayList<Integer> topSort = new ArrayList<>();
        while(!st.isEmpty()) {
            topSort.add(st.pop());
        }
        
        return topSort;
        
    }
    
    public void dfsTraversal(int[][] edges, List<List<Integer>> adjancyList, int[] visited, int root, Stack<Integer> st) {
        visited[root] = 1;
        
        for(int num : adjancyList.get(root)) {
            if(visited[num] == 0) {
                dfsTraversal(edges, adjancyList, visited, num, st);
            }
        }
        
        st.push(root);
    }
}