class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> cache = new HashMap<>();
        return findTargetSubWays(nums, target, 0, cache);
    }
    private int findTargetSubWays(int[] nums, int target, int idx, Map<String, Integer> cache) {
        String key = String.valueOf(idx) + "#" + String.valueOf(target);
        if (!cache.containsKey(key)) {
            int ans;
            if (idx == nums.length) {
                if (target == 0) {
                   ans = 1; 
                }else {
                    ans = 0;
                }
            }else {
                ans = findTargetSubWays(nums, target + nums[idx], idx + 1, cache) + findTargetSubWays(nums, target - nums[idx], idx + 1, cache);
            }
            cache.put(key, ans);
        }
        return cache.get(key);
    }
}