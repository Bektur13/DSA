public class Sorting {
    public static void main(String[] args) {

        //MAXIMUM PRODUCT DIFFERENCE BETWEEN TWO PAIRS
            //MY SOLUTION NO OPTIMIZATION
        public int maxProductDifference(int[] nums) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for(int num : nums) {
                minHeap.offer(num);
                maxHeap.offer(num);
            }

            return (maxHeap.poll() * maxHeap.poll()) - (minHeap.poll() * minHeap.poll());
        }
            // AZRET BAIKE SOLUTION WITH OPTIMIZATION

        public int maxProductDifferenceOptimized(int[] nums) {
            int n = nums.length;
            int largest = 0; secondLargest = 0;
            int smallest = 10001; secondSmallest = 10001;
            for(int i = 0; i < nums.length; i++) {
                // Find two largest elements in nums[]
                if(nums[i] >= largest) {
                    secondLargest = largest;
                    largest = nums[i];
                }else if(nums[i] > secondLargest) {
                    secondLargest = nums[i];
                }

                // Find two smallest element in nums[]
                if(nums[i] <= smallest) {
                    secondSmallest = smallest;
                    smallest = nums[i];
                }else if(nums[i] < secondSmallest) {
                    secondSmallest = nums[i];
                }
            }

            return (largest * secondLargest) - (smallest * secondSmallest);
        }
    }
}