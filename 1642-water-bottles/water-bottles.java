class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            ans += numBottles / numExchange;
            if (numBottles % numExchange == 0) {
                numBottles = numBottles / numExchange;
            } else {
                int rem = numBottles % numExchange;
                numBottles = numBottles / numExchange + rem;

            }

        }
        return ans;

    }
}