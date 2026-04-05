
import java.util.*;

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        
        int len = val.length;
        List<List<Integer>> list = new ArrayList<>();
        
        for(int j = 0 ; j < len; j++) {
            List<Integer> currList = new ArrayList<>();
            currList.add(val[j]);
            currList.add(wt[j]);
            
            list.add(currList);
        }
        Collections.sort(list, (a, b) -> {
            double newValue1 = (double) a.get(0)/a.get(1);
            double newValue2 = (double) b.get(0)/b.get(1);
            return Double.compare(newValue1, newValue2);
        });
        
        // System.out.println(list);
        
        int i = len - 1;
        double answer = 0.0;
        int newCap = capacity;
        
        while(i >= 0) {
            if(list.get(i).get(1) <= newCap) {
                newCap -= list.get(i).get(1);
                answer += list.get(i).get(0);
            }
            else {
               double newVal = (double)(list.get(i).get(0))/(list.get(i).get(1)) ;
               answer += (newCap * newVal);
               break;
            }
            i--;
        }
        
        return answer;
         
    }
}