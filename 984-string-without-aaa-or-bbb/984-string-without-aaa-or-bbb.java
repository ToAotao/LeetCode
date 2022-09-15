class Solution {
    
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        char ac = 'a';
        char bc = 'b';
        int A = a, B = b;
        if (A < B) {
            A = b;
            B = a;
            ac = 'b';
            bc = 'a';
        }
        while (A > 0) {
            sb.append(ac);
            A--;
            if (A > B) {
                sb.append(ac);
                A--;
            }
            if (B > 0) {
                sb.append(bc);
                B--;
            }
        }
        return sb.toString();
    }
    
}