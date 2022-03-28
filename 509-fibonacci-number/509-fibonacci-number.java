class Solution {
    public int fib(int n) {
        int[] helper = new int[n + 1];
        return job(helper, n);
    }
    public int job(int[] helper, int n) {
        if (n == 0 || n == 1) return n;
        if (helper[n] != 0) return helper[n];
        helper[n] = job(helper, n - 1) + job(helper, n - 2);
        return helper[n];
    }
}