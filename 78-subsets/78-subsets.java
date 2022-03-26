class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        
        backTrack(nums, track, 0);
        return res;
    }
    public void backTrack(int[] nums, LinkedList<Integer> track, int start) {
        res.add(new LinkedList<Integer>(track));
        for (int i = start; i < nums.length; i++) {
            
            track.addLast(nums[i]);
            backTrack(nums, track, i+1);
            track.removeLast();
        }
    }
}