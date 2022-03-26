//   1        2            2
//  12,      22
// 122
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track, 0);
        return res;
    }
    public void backTrack(int[] nums, LinkedList<Integer> track, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++){
            if (i > start &&  nums[i] == nums[i - 1]) {
                continue;
            }

            track.addLast(nums[i]);
            backTrack(nums, track, i + 1);
            track.removeLast();
        }
    }
}