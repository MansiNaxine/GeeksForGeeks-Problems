class Solution {
    public int spanningTree(int V, int[][] edges) {
        
        int n = edges.length;
        DisJointUnion unionObj = new DisJointUnion(V);
        
        List<List<Integer>> list = new ArrayList<>();
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            List<Integer> currList = new ArrayList<>();
            int u = edges[i][0];
            int v = edges[i][1];
            int e = edges[i][2];
            
            currList.add(e);
            currList.add(u);
            currList.add(v);
            
            
            list.add(new ArrayList<>(currList));
        }
        
        Collections.sort(list, (x, y) -> Integer.compare(x.get(0), y.get(0)));
        
        for(int i = 0; i < n; i++) {
            int u = list.get(i).get(1);
            int v = list.get(i).get(2);
            int e = list.get(i).get(0);
            
            if(unionObj.findParent(u) != unionObj.findParent(v)) {
                sum += e;
                unionObj.formUnion(u, v);
            }
        }
        
        return sum;
    }
}

class DisJointUnion {
    
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    DisJointUnion(int len) {
        for(int i = 0; i <= len; i++) {
            size.add(1);
            parent.add(i);
        }
    }
    
    
    public int findParent(int node) {
        if(node == parent.get(node)) return node;
        return findParent(parent.get(node));
    }
    
    public void formUnion(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);
        
        if(size.get(parentU) < size.get(parentV)) {
            parent.set(parentU, parentV);
            size.set(parentV , size.get(parentV) + size.get(parentU));
        }
        else {
            parent.set(parentV, parentU);
            size.set(parentU , size.get(parentV) + size.get(parentU));
        }
    }
}