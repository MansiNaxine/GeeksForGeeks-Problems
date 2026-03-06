// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        
        int n = pre_exp.length();
        int i = n - 1;
        Stack<String> st = new Stack<>();
        // StringBuilder answer = new StringBuilder("");
        
        while(i >= 0) {
            char ch = pre_exp.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                String str = String.valueOf(ch);
                st.add(str);
            }
            else {
                String top1 = st.pop();
                String top2 = st.pop();
                StringBuilder sb = new StringBuilder("");
                sb.append('(');
                sb.append(top1);
                sb.append(ch);
                sb.append(top2);
                sb.append(')');
                
                st.push(sb.toString());
                
            }
            i--;
        }
        
        return st.pop();
        
        
    }
}
