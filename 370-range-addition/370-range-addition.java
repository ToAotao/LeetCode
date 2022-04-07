class Different {
    int[] diff;
    public Different(int[] arr){
        assert arr.length > 0;
        diff = new int[arr.length];
        diff[0] = arr[0]; 
        for (int i = 1; i < arr.length; i++) {
            diff[i] =  arr[i] - arr[i - 1];
        }
    }
    public void increment(int i, int j, int n) {
        diff[i] += n;
        if (j + 1 < diff.length) {
            diff[j + 1] -= n;
        }
    }
    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }
}
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        Different diff = new Different(ans);
        for (int[] operation : updates) {
            int startIdx = operation[0];
            int endIdx = operation[1];
            int incre = operation[2];
            diff.increment(startIdx, endIdx, incre);
        }
        return diff.result();
    }
}