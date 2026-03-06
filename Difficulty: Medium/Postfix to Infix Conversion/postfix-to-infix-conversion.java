// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        
        int n = exp.length();
        int i = 0;
        Stack<String> st = new Stack<>();
        
        while(i < n) {
            char ch = exp.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                String str = String.valueOf(ch);
                st.push(str);
            }
            else {
                String top1 = st.pop();
                String top2 = st.pop();
                StringBuilder sb = new StringBuilder("");
                sb.append("(");
                sb.append(top2);
                sb.append(ch);
                sb.append(top1);
                sb.append(")");
                
                st.push(sb.toString());
                
            }
            
            i++;
        }
        
        return st.pop();
        
    }
}
