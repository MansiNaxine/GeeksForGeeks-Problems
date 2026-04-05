class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        
        List<List<Integer>> list = new ArrayList<>();
        int n = start.length;
        
        for(int i = 0; i < n; i++) {
            List<Integer> currList = new ArrayList<>();
            currList.add(start[i]);
            currList.add(end[i]);
            
            list.add(new ArrayList<>(currList));
        }
        
        Collections.sort(list, (a, b) -> a.get(1).compareTo(b.get(1)));
        
        int firstStart = list.get(0).get(0);
        int firstEnd = list.get(0).get(1);
        int cnt = 1;
        
        for(int i = 1; i < n; i++) {
            int startCurr = list.get(i).get(0);
            if(startCurr > firstEnd) {
                cnt += 1;
                firstEnd = list.get(i).get(1);
            }
        }
        
        return cnt;
    }
}
