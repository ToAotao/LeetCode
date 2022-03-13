class Solution {
    public int[][] generateMatrix(int n) {

    int[][] matrix = new int[n][n];

    int upper_bound = 0, lower_bound = n - 1;

    int left_bound = 0, right_bound = n - 1;

    // 需要填入矩阵的数字

    int num = 1;

    

    while (num <= n * n) {
//from left to right
        if (upper_bound <= lower_bound) {
            for (int i = left_bound; i <= right_bound; ++i) {
                matrix[upper_bound][i] = num++;
            }
            ++upper_bound;
        }
//from top to bot
        if (left_bound <= right_bound) {
            for (int i = upper_bound; i <= lower_bound; ++i) {
                matrix[i][right_bound] = num++;
            }
            --right_bound;
        }
//from right to left
        if (upper_bound <= lower_bound) {
            for (int i = right_bound; i >= left_bound; --i) {
                matrix[lower_bound][i] = num++;
            }
            --lower_bound;
        }
        if(left_bound <= right_bound) {
            for (int i = lower_bound; i >= upper_bound; --i) {
                matrix[i][left_bound] = num++;
            }
            ++left_bound;
        }
        
    }

    return matrix;

    }

}