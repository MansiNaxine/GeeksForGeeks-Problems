class Solution {
    public int spanningTree(int V, int[][] edges) {
       
       //Create an Adjancy List
       List<List<List<Integer>>> adjancyList = new ArrayList<>();
       for(int i = 0 ; i < V; i++) {
           adjancyList.add(new ArrayList<>());
       }
       
       for(int i = 0; i < edges.length; i++) {
           int u = edges[i][0];
           int v = edges[i][1];
           int e = edges[i][2];
           
           List<Integer> currList1 = new ArrayList<>();
           currList1.add(v);
           currList1.add(e);
           
           adjancyList.get(u).add(new ArrayList<>(currList1));
           
           List<Integer> currList2 = new ArrayList<>();
           currList2.add(u);
           currList2.add(e);
           
           adjancyList.get(v).add(new ArrayList<>(currList2));
       }
       
       int[] visited = new int[V];
       int sum = 0;
       
       PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> a.x - b.x);
       que.add(new Pair(0, 0));
       
       while(!que.isEmpty()) {
           Pair currP = que.remove();
           int nodeWt = currP.x;
           int root = currP.y;
           
           if(visited[root] == 1) continue;
           else {
               visited[root] = 1;
               sum += nodeWt;
               
               for(List<Integer> curr : adjancyList.get(root)) {
                   int node = curr.get(0);
                   int wt = curr.get(1);
                   
                   if(visited[node] == 0) {
                       que.add(new Pair(wt, node));
                   }
               }
           }
       }
       
       return sum;
        
    }
}


class Pair {
    int x;
    int y;
    Pair inner;
    
    Pair(int x, Pair inner) {
        this.x = x;
        this.inner = inner;
    }
    
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}