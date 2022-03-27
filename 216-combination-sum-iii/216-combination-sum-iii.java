class Solution {
    int sum = 0;
    int count = 0;
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(track, k, n, 1);
        return res;
    }
    public void backTrack(LinkedList<Integer> track, int k, int n, int start) {
        if (sum == n && count == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > n) {
            return;
        }
        if (count > k) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            
            sum += i;
            track.addLast(i);
            count++;
            backTrack(track, k, n, i + 1);
            count--;
            track.removeLast();
            sum-=i;
        }
    }
}