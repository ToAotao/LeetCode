class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if ( sum % k != 0) return false;
        int used = 0; //use bitset 32 bits!
        int target = sum / k;
        return backTrack(k, 0, nums, 0, used, target);
    }
    HashMap<Integer, Boolean> memo = new HashMap();
    public boolean backTrack(int k, int bucket, int[] nums, int start, int used, int target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            boolean res = backTrack(k - 1, 0, nums, 0, used, target);
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        for (int i = start; i< nums.length; i++) {
            if (((used >> i) & 1) == 1) continue;
            if (nums[i] + bucket > target) continue;
            used |= 1 << i;
            bucket += nums[i];
            if (backTrack(k ,bucket, nums, i+ 1, used, target)) return true;
            used ^= 1 << i;
            bucket -= nums[i];
        }
        return false;
    }
}