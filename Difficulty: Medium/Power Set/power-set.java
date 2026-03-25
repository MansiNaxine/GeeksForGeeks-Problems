// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        helper(0, s, answer, sb);
        Collections.sort(answer);
        return answer;
    }
    
    public void helper(int index, String s, List<String> answer , StringBuilder sb ) {
        //base case;
        if(index >= s.length()) {
            String str = sb.toString();
            if(str.isEmpty()) return;
            else answer.add(str);
            return;
        }
        
        //recursive case
        sb.append(s.charAt(index));
        helper(index + 1, s, answer, sb);
        sb.deleteCharAt(sb.length() - 1);
        helper(index + 1, s, answer, sb);
    }
}