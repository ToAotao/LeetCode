class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int row =0; row < reservedSeats.length; row++) {
            List<Integer> seats = map.getOrDefault(reservedSeats[row][0], new ArrayList<>());
            seats.add(reservedSeats[row][1]);
            map.put(reservedSeats[row][0], seats);

        }
        int res = (n - map.size()) * 2;
        for (int row : map.keySet()) {
            boolean left = true, right = true, mid = true;
            
            for (int col : map.get(row)){
                if (col >= 2 && col <= 5) left = false;
                if (col >= 4 && col <= 7) mid = false;
                if (col >= 6 && col <= 9) right = false;
            }
            
            if (left && right) {
                res += 2;
            }else if (right || mid || left) {
                res += 1;
            }
        }
        return res;
    }
}