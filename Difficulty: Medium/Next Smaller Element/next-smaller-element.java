class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
       
       int n = arr.length;
       Stack<Integer> st = new Stack<>();
       ArrayList<Integer> answer = new ArrayList<>();
       
       for(int i = 0; i < n; i++) {
           answer.add(-1);
       }
       
       for(int i = n - 1; i >= 0; i--) {
           
           while(!st.isEmpty() && st.peek() >= arr[i]) {
               st.pop();
           }
           
           if(!st.isEmpty()) answer.set(i, st.peek());
           
           st.push(arr[i]);
       }
       
       return answer;
        
    }
}