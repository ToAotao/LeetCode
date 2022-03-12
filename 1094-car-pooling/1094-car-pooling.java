class Difference {
    private int[] diff;
    public Difference(int[] arr){
        assert arr.length > 0;
        diff = new int[arr.length];
        diff[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
    }
    public void increment(int i, int j, int num) {
        diff[i] += num;
        if (j + 1 < diff.length){
            diff[j + 1] -= num;
        }
    }
    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for(int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
class Solution {
   boolean carPooling(int[][] trips, int capacity) {

    // 最多有 1000 个车站

    int[] nums = new int[1001];

    // 构造差分解法

    Difference df = new Difference(nums);

    

    for (int[] trip : trips) {

        // 乘客数量

        int val = trip[0];

        // 第 trip[1] 站乘客上车

        int i = trip[1];

        // 第 trip[2] 站乘客已经下车，

        // 即乘客在车上的区间是 [trip[1], trip[2] - 1]

        int j = trip[2] - 1;

        // 进行区间操作

        df.increment(i, j, val);

    }

    

    int[] res = df.result();

    

    // 客车自始至终都不应该超载

    for (int i = 0; i < res.length; i++) {

        if (capacity < res[i]) {

            return false;

        }

    }

    return true;

}

}