class Solution {
    int countFreq(int[] arr, int target) {
        
        int n = arr.length;
        int firstOccu = findFirstOccurence(arr, target);
        int secondOccu = -1;
        int answer = 0;
        if(firstOccu != -1) {
            secondOccu = findSecondOccurence(arr, target);
            answer = secondOccu - firstOccu + 1;
        }
        else {
            return answer;
        }

        return answer;
    }

    public int findFirstOccurence(int[] arr, int target) {

        int ans = -1;
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {

            int mid = (start + end) /2;

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        if(ans >= 0 && arr[ans] != target) return -1;
        return ans;
    }

    public int findSecondOccurence(int[] arr, int target) {

        int ans = -1;
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {

            int mid = (start + end) /2;

            if (arr[mid] <= target) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        if(ans >= 0 && arr[ans] != target) return -1;
        return ans;
        
    }
}
