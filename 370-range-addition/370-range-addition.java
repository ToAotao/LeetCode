class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int startIdx = updates[i][0];
            int endIdx = updates[i][1];
            int inc = updates[i][2];
            for(int j = startIdx; j <= endIdx; j++) {
                arr[j] += inc;
            }
        }
        return arr;
    }
}