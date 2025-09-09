public class Sorting {
    public static void main(String[] args) {
        public int maxProductDifference(int[] nums) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for(int num : nums) {
                minHeap.offer(num);
                maxHeap.offer(num);
            }

            return (maxHeap.poll() * maxHeap.poll()) - (minHeap.poll() * minHeap.poll());
        }
    }
}