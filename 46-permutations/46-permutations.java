class Solution {
    List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(nums, track, used);
        return res;
    }
    public void backTracking (int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backTracking(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}