class NumArray {
    private int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        int i = 0;
        for(int num : nums){
            arr[i] = num;
            i++;
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++){
            sum += arr[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */