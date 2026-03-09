
class Solution {
    public static int[] count_NGE(int arr[], int indices[]) {
        
        int m = indices.length;
        int n = arr.length;
        int[] answer = new int[m];
        
        for(int i = 0; i < m; i++) {
            int j = 0;
            int k = n - 1;
            while(j != indices[i]) {
                j++;
            }
            int cnt = 0;
            while(k > j) {
                if(arr[k] > arr[j]) cnt += 1;
                k--;
            }
            answer[i] = cnt;
        }
        
        return answer;
     
    }
}
