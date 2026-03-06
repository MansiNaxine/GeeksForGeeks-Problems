class Solution {
    public static String infixToPostfix(String s) {
       
       int i = 0;
       Stack<Character> st = new Stack<>();
       StringBuilder ans = new StringBuilder("");
       int n = s.length();
       
       while(i < n) {
           char ch = s.charAt(i);
           if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
               ans = ans.append(ch);
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
               if(ch == '^') {
                    while(!st.isEmpty() && priority(ch) < priority(st.peek())) {
                        ans.append(st.pop());
                     }
               }
               else {
                   while(!st.isEmpty() && priority(ch) <= priority(st.peek())) {
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
    
    public static int priority(char ch) {
        if(ch == '^') return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return -1;
    }
}