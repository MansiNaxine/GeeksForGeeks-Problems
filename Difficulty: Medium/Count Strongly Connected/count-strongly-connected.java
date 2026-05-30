class Solution {
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
     
    
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> adjancyList = new ArrayList<>();
        
        for(int i = 0 ; i < V; i++) {
            adjancyList.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjancyList.get(u).add(v);
        }
        
        //First sort according to finishing time
        //Kosaraju's Algorithm
        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
                dfs(st, adjancyList, i, vis);
            }
        }
        
        //reverse the edges
        int[] visNew = new int[V];
        List<List<Integer>> adjancyListNew = new ArrayList<>();
        
        for(int i = 0 ; i < V; i++) {
            adjancyListNew.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++) {
            for(int num : adjancyList.get(i)) {
                adjancyListNew.get(num).add(i);
            }
        }
        
        int scc = 0;
        
        for(int i = 0 ; i < V; i++) {
            int ele = st.pop();
            if(visNew[ele] == 0) {
                scc++;
                dfsSCC(adjancyListNew, ele, visNew);
            }
        }
        
        return scc;
    
    }
    
    public void dfsSCC( List<List<Integer>> adjancyList, int root, int[] vis) {
        vis[root] = 1;
        
        for(int num : adjancyList.get(root)) {
            if(vis[num] == 0) {
                dfsSCC(adjancyList, num, vis);
            }
        }
    }
    
    public void dfs(Stack<Integer> st, List<List<Integer>> adjancyList, int root, int[] vis) {
        vis[root] = 1;
        
        for(int num : adjancyList.get(root)) {
            if(vis[num] == 0) {
                dfs(st, adjancyList, num, vis);
            }
        }
        
        st.add(root);
    }
    
}