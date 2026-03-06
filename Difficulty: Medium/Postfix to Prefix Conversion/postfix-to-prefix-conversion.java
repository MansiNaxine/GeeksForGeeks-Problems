// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
       
       int n = post_exp.length();
       int i = 0;
       Stack<String> st = new Stack<>();
       
       while(i < n) {
           char ch = post_exp.charAt(i);
           if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
               String str = String.valueOf(ch);
               st.push(str);
           }
           else {
               String top1 = st.pop();
               String top2 = st.pop();
               StringBuilder sb = new StringBuilder("");
               sb.append(ch);
               sb.append(top2);
               sb.append(top1);
               
               st.push(sb.toString());
               
           }
           i++;
       }
       
       return st.pop();
        
    }
}
