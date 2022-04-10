class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            
            while(right - left >= 9) {
                String str = s.substring(left, right+1);
                if (set.contains(str) && !res.contains(str)) {
                    res.add(str);
                }
                set.add(str);
                left++;
            }
            right++;
        }
        return res;
    }
}