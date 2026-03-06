// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        int n = pre_exp.length();
        Stack<String> st = new Stack<>();
        int i = n - 1;
        
        while(i >= 0) {
            char ch = pre_exp.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                String str = String.valueOf(ch);
                st.push(str);
            }
            else {
                String top1 = st.pop();
                String top2 = st.pop();
                StringBuilder sb = new StringBuilder("");
                sb.append(top1);
                sb.append(top2);
                sb.append(ch);
                
                st.push(sb.toString());
            }
            i--;
        }
        
        
        return st.pop();
    }
}
