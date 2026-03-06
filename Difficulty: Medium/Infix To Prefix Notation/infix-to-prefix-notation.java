class Solution {
    public String infixToPrefix(String s) {
        
        
        StringBuilder sb = new StringBuilder(s);
        String newString = sb.reverse().toString();
        newString = convertParanthesis(newString);
        String answer = convertInfixToPostfix(newString);
        StringBuilder ans = new StringBuilder(answer);
        String ansNew = convertParanthesis(ans.reverse().toString());
        
        return ansNew;
        
    }
    
    public String convertParanthesis(String ans) {
        StringBuilder sb = new StringBuilder(ans);
        
        for(int i = 0; i < ans.length(); i++) {
            if(sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            }
            else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }
        
        return sb.toString();
    }
    
    public int priority(char ch) {
        if(ch == '^') return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return -1;
        
    }
    
    public String convertInfixToPostfix(String s) {
        int n = s.length();
        int i = 0;
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        
        while(i < n) {
            char ch = s.charAt(i);
            //first check is for operand
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                ans.append(ch);
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            }
            else {
                if (ch == '^') {
                    while(!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                        ans.append(st.pop());
                    }
                }
                else {
                    while(!st.isEmpty() && priority(ch) < priority(st.peek())) {
                        ans.append(st.pop());
                    }
                }
                
                st.push(ch);
            }
            i++;
        }
        
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        
        return ans.toString();
    }
}