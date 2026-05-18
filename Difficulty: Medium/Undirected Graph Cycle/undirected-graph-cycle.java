class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
        List<List<Integer>> adjancyList = new ArrayList<>();
        if(V <= 2) return false;
        for(int i = 0; i < V; i++) {
            adjancyList.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjancyList.get(u).add(v);
            adjancyList.get(v).add(u);
        }

        int[] visited = new int[V];
        
        for(int start = 0; start < V; start++) {
            if(visited[start] == 1) continue;
            Queue<Pair> que = new LinkedList<>();
            Pair p = new Pair(start, -1);
            que.add(p);
            visited[start] = 1;
    
            while(!que.isEmpty()) {
                int currNode = que.peek().node;
                int parentNode = que.peek().parent;
    
                que.remove();
    
                if(!adjancyList.get(currNode).isEmpty()) {
                    for(int i = 0; i < adjancyList.get(currNode).size(); i++) {
                        if(visited[adjancyList.get(currNode).get(i)] == 0) {
                            visited[adjancyList.get(currNode).get(i)] = 1;
                            Pair pair = new Pair(adjancyList.get(currNode).get(i), currNode);
                            que.add(pair);
                        }
                        else if(parentNode != adjancyList.get(currNode).get(i)) {
                            return true;
                        }
                    }
                }
            }
        }
        

        return false;

    }
}

class Pair {
    int node;
    int parent;
    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}