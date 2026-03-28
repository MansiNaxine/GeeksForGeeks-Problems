class Solution {
    public void sortStack(Stack<Integer> st) {
        
        int[] nums = new int[st.size()];
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            nums[i] = st.pop();
        }
        
        mergeSort(nums, 0, n - 1);
        for(int i = 0; i < n; i++) {
            st.push(nums[i]);
        }
        
    }
    
    public static void mergeSort(int[] arr, int start, int end) {

        //We have to solve it recursively
        //base case
        if(start >= end) return;

        //recursive case
        int mid = (start + end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {

        List<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid + 1;

        while(i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            }
            else {
                temp.add(arr[j]);
                j++;
            }
        }

        while(i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        while(j <= end) {
            temp.add(arr[j]);
            j++;
        }

        int index = 0;
        for(int k = start; k <= end; k++) {
            arr[k] = temp.get(index);
            index++;
        }
    }
}