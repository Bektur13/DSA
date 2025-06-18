public static void main(String[] args) {
//  4. Capacity to ship n packages within d days
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int smallestCapacity = weights[0];
            int sumOfWeights = 0;
            for(int i = 0; i < weights.length; i++) {
                if(weights[i] > smallestCapacity) {
                    smallestCapacity = weights[i];
                }
                sumOfWeights += weights[i];
            }
            while(smallestCapacity < sumOfWeights) {
                int mid = smallestCapacity + (sumOfWeights - smallestCapacity) / 2;
                int totalDays = capacityChecker(weights, mid);
                if(totalDays > days) {
                    smallestCapacity = mid + 1;
                }else{
                    sumOfWeights = mid;
                }
            }
            return smallestCapacity;
        }

        public int capacityChecker(int[] weights, int capacity) {
            int daysNeeded = 1;
            int currentDay = 0;
            for(int packageWeight : weights) {
                if((packageWeight + currentDay) > capacity) {
                    daysNeeded++;
                    currentDay = packageWeight;
                }else {
                    currentDay += packageWeight;
                }
            }
            return daysNeeded;
        }
    }
}