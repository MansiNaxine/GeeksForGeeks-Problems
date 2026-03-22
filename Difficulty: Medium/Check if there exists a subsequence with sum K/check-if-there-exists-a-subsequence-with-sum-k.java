// User function Template for Java

class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        
        return helper(arr, 0, K);
        
    }
    
    // public static List<List<Integer>> oneCombinationSum(int[] arr, List<List<Integer>> answer, int sum) {
    //     if(helper(arr, answer, new ArrayList<>(), 0, sum)) return answer;
    //     else return new ArrayList<>();
    // }

    public static boolean helper(int[] arr, int index, int sum) {
        //base case
        if(index >= arr.length) {
            if(sum == 0) {
                // answer.add(new ArrayList<>(currSeq));
                return true;
            }
            else {
                return false;
            }
        }


        //recursive case

        if(sum >= arr[index]) {
            // currSeq.add(arr[index]);
            if (helper(arr, index + 1, sum - arr[index])) return true;
            // currSeq.removeLast();
        }
        // int currIndex = index + 1;
        // while(currIndex > 0 && currIndex < arr.length && arr[currIndex] == arr[currIndex - 1]) {
        //     currIndex++;
        // }

        return helper(arr, index + 1, sum);
    }
}
