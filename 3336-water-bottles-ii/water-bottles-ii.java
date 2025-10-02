class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            ans += 1;
            numBottles -= numExchange;
            numExchange++;
            numBottles += 1;
        }

        return ans;

    }
}