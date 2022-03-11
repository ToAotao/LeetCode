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
    public void increment(int i, int j, int x){
        diff[i] += x;
        if (j + 1 < diff.length){
            diff[j + 1] -= x;
        }
        
    }
    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++){
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
        
}

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];
        Difference diff = new Difference(flights);
        for(int i = 0; i < bookings.length; i++) {
            diff.increment(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
        }
        return diff.result();
    }
}