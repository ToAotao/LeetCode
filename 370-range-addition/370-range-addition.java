class Difference {
    private int[] diff;
    public Difference(int[] arr) {
        assert arr.length > 0;
        diff = new int[arr.length];
        diff[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff[i] = arr[i] - arr[i -1]; 
        }
    }
    
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }
    
    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i ++) {
            res[i] = res[i - 1] + diff[i];
            
        }
        return res;
    }
}
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        Difference diff = new Difference(arr);
        for (int i = 0; i < updates.length; i++) {
            diff.increment(updates[i][0], updates[i][1], updates[i][2]);
        }

        return diff.result();
    }
}