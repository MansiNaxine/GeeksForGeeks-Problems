class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        //Create and adjancy List
        List<List<Integer>> adjancyList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjancyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjancyList.get(u).add(v);
        }
        
        int[] visited = new int[V];
        int[] pathArray = new int[V];
        for(int i = 0 ; i < V; i++) {
            if(visited[i] == 0) {
                if(dfsTraversal(adjancyList, visited, i, pathArray)) return true;
            }
        }
        
        return false;
    }

    public boolean dfsTraversal(List<List<Integer>> adjancyList, int[] visited , int root, int[] pathArray) {
        visited[root] = 1;
        pathArray[root] = 1;
        
        // if(adjancyList.get(root).size() == 0) return false;
        
        for(int ele : adjancyList.get(root)) {
            if(visited[ele] == 0) {
                if(dfsTraversal(adjancyList, visited, ele, pathArray)) return true;
            }
            else if(pathArray[ele] == 1) return true;
        }
        
        pathArray[root] = 0;
        
        return false;
    }
}