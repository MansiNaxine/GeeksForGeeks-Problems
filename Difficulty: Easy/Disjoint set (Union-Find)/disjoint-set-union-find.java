class Solution {
    public ArrayList<Integer> DSU(int n, int[][] queries) {
        
       Disjoint unionObj = new Disjoint(n);
       ArrayList<Integer> answer = new ArrayList<>();
       
       for(int i = 0; i < queries.length; i++) {
           int len = queries[i].length;
           if(len == 2) answer.add(unionObj.findUParent(queries[i][1]));
           else {
                if(queries[i][2] != queries[i][1]) unionObj.formUnion(queries[i][2], queries[i][1]);
            }
       }
       
       return answer;
    }
}

class Disjoint {
    
    //  List<Integer> size = new ArrayList<>();
     List<Integer> parent = new ArrayList<>();
    
    Disjoint(int len) {
        for(int i = 0; i <= len; i++) {
            // size.add(1);
            parent.add(i);
        }
    }
    
    public int findUParent(int num) {
        if(num == parent.get(num)) return num;
        return findUParent(parent.get(num));
    }
    
    public void formUnion(int u, int v) {
        int parentU = findUParent(u);
        int parentV = findUParent(v);
        
        // if (size.get(parentU) < size.get(parentV)) {
        //     parent.set(parentU, parentV);
        //     size.set(parentV, size.get(parentV) + size.get(parentU));
        // }
        // else {
            parent.set(parentV, parentU);
            // size.set(parentU, size.get(parentV) + size.get(parentU));
        // }
    }
}


