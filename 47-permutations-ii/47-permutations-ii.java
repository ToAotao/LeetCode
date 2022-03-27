class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, track, visited);
        return res;
    }
    public void backTrack(int[] nums, LinkedList<Integer> track, boolean[] visited){
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if ( i > 0 &&nums[i] == nums[i - 1] && !visited[i-1] ) {
                continue;
            }
            track.addLast(nums[i]);
            visited[i] = true;
            backTrack(nums, track, visited);
            visited[i] = false;
            track.removeLast();
        }
    }
}