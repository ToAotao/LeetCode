class Solution {
    List<List<Integer>> res = new LinkedList<>();
    int trackSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(candidates, track, 0, target);
        return res;
    }
    public void backTrack(int[] nums, LinkedList<Integer> track, int start, int target) {
        if (trackSum > target) return;
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            trackSum += nums[i];
            track.addLast(nums[i]);
            backTrack(nums, track, i + 1, target);
            track.removeLast();
            trackSum -= nums[i];
        }
    }
}