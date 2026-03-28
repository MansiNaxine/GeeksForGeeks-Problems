class Solution {
    public static void reverseStack(Stack<Integer> st) {
         int[] nums = new int[st.size()];
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            nums[i] = st.pop();
        }
        
        // reverseArr(nums, 0, n - 1);
        
        for(int i = 0; i < n; i++) {
            st.push(nums[i]);
        }
        
    }
    
    // public static void reverseArr(int[] nums, int start, int end) {
        
    //     //base case
    //     if(start >= end) return;
        
    //     //recursive case
    //     int temp = st.get(start);
    //     nums[start] = nums[end];
    //     nums[end] = temp;
    //     reverseArr(nums, start + 1, end - 1);
    // }
}
