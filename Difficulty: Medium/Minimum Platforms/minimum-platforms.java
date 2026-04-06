class Solution {
    public int minPlatform(int arr[], int dep[]) {
        
        //return bruteForceApproach(arr, dep);
        return optimalApproach(arr, dep);
        
        
    }
    
    public int optimalApproach(int[] arr, int[] dep) {
        int len = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int cnt = 0;
        int maxCnt = Integer.MIN_VALUE;
        
        while(i < len) {
            if(arr[i] <= dep[j]) {
                cnt += 1;
                i++;
            }
            else {
                cnt -= 1;
                j++;
            }
            
            maxCnt = Math.max(maxCnt, cnt);
        }
        
        return maxCnt;
    }
    
    public int bruteForceApproach(int[] arr, int[] dep) {
        int len = arr.length;
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            List<Integer> currSeq = new ArrayList<>();
            currSeq.add(arr[i]);
            currSeq.add(dep[i]);
            
            list.add(new ArrayList<>(currSeq));
        }
        
        Collections.sort(list, (a, b) -> a.get(1).compareTo(b.get(1)));
        
        int stations = 1;
        
        
        for(int i = 0; i < len; i++) {
            int end = list.get(i).get(1);
            int cnt = 1;
            for(int j = 0; j < len; j++) {
                if(i != j) {
                    int jthStart = list.get(j).get(0);
                    int jthEnd = list.get(j).get(1);
                    
                    if((jthStart <= end && jthEnd >= end)){
                        cnt += 1;
                    }
                }
            }
            stations = Math.max(stations, cnt);
        }
        
        return stations;
    }
}
