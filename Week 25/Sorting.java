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

        //H-INDEX
            // MY SOLUTION
        public int hIndex(int[] citations) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for(int citation : citations) {
                maxHeap.offer(citation);
            }

            int h = 0;
            while(!maxHeap.isEmpty()) {
                int currentCitation = maxHeap.poll();
                h++;
                if(currentCitation < h) {
                    return h - 1;
                }
                }
            return h;
        }
            // AZRET BAIKE'S SOLUTION OPTIMIZED
        public int hIndexOptimized(int[] citations) {
            int n = citations.length;
            int[] buckets = new int[n + 1];
            for(int c : citations) {
                if(c > n) {
                    buckets[n]++;
                }else {
                    buckets[c]++;
                }
            }

            int count = 0;
            for(int i = n; i >= 1; i--) {
                count += buckets[i];

                if(count >= i) {
                    return i;
                }
            }

            return 0;
        }

        //SORT AN ARRAY
            // MY SOLUTION
        public int[] sortArray(int[] nums) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int num : nums) {
                minHeap.offer(num);
            }

            for(int i = 0; i < nums.length; i++) {
                nums[i] = minHeap.poll();
            }

            return nums;
        }
            // AZRET BAIKE'S SOLUTION OPTIMIZED
        public int[] sortArrayOptimized(int[] nums) {
            int n = nums.length;

            for(int i = 0; i < n; i++) {
                nums[i] += 50000;
            }

            int k = 100000;
            int[] b = new int[n];
            int[] c = new int[k + 1];
            for(int i = 0; i < k; i++) {
                c[i] = 0;
            }
            for(int j = 0; j < n; j++) {
                c[nums[j]]++;
            }
            for(int j = 1; j <= k; j++) {
                c[j] += c[j-1];
            }
            for(int j = n - 1; j >= 0; j--) {
                b[c[nums[j]] - 1] = nums[j];
                c[nums[j]]--;
            }

            for(int i = 0; i < n; i++){
                b[i] -= 50000;
            }

            return b;
        }
    }
}