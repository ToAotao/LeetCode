class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upperBound  = 0;
        int rightBound = n - 1;
        int leftBound = 0;
        int bottomBound = m - 1;
        List<Integer> res = new LinkedList<>();
        while (res.size() < m * n) {
            if (upperBound <= bottomBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    res.add(matrix[upperBound][j]);
                }
                upperBound++;
            }
            if(leftBound <= rightBound) {
                for (int i = upperBound; i <= bottomBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            if (upperBound <= bottomBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    res.add(matrix[bottomBound][j]);
                }
                bottomBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = bottomBound; i >= upperBound; i--) {
                    res.add(matrix[i][leftBound]);
                    System.out.println(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }        
        return res;
    }
}