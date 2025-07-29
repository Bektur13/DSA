class Solution {
    public static void main(String[] args) {
        // Kth Smallest Number in Multiplication Table
        public int findKthNumber(int m, int n, int k) {
            int left = 1;
            int right = m * n;
            int answer = -1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                int count = countNumsLessThanOrEqualToValueInMultTableMbyN(middle, m, n);
                if (count >= k) {
                    answer = middle;
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            // T: O(log(m*n) * m) <-> O(m*n)
            return answer;
        }

        private int countNumsLessThanOrEqualToValueInMultTableMbyN(int value, int m, int n) {
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(value / i, n);
            }
            return count;
        }
        // Capacity to ship n packages within d days
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