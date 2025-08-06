public class Heap {
    public static void main(String[] args) {
        // Kth LARGEST ELEMENT IN STEAM
        class KthLargest {
            private PriorityQueue<Integer> minHeap;
            private int k;

            public KthLargest(int k, int[] nums) {
                this.minHeap = new PriorityQueue<>();
                this.k = k;

                for(int n : nums) {
                    add(n);
                }
            }

            public int add(int val) {
                if (minHeap.size() < k) {
                    minHeap.offer(val);
                } else if (val > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(val);
                }

                return minHeap.peek();
            }

        }

        // LAST STONE WEIGHT
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

            for(int stone : stones) {
                q.add(stone);
            }


            while(q.size() > 1) {
                int temp = q.poll() - q.poll();
                q.offer(temp);
            }

            return q.poll();
        }
    }
}