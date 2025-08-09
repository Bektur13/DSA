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

        // Kth LARGEST ELEMENT IN ARRAY
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            for(int num : nums) {
                q.offer(num);
            }

            while(k != 1) {
                q.poll();
                k--;
            }
            return q.poll();
        }

        // TASK SCHEDULER
        public int leastInterval(char[] tasks, int cooldown) {
            int[] taskCounts = new int[26];
            int maxFrequency = 0;
            for (char task : tasks) {
                int index = task - 'A';
                taskCounts[index]++;]
                maxFrequency = Math.max(maxFrequency, taskCounts[index]);
            }

            int maxFrequencyTasks = 0;
            for (int count : taskCounts) {
                if (count == maxFrequency) {
                    maxFrequencyTasks++;
                }
            }

            int minScheduleLength = Math.max(tasks.length, (maxFrequency - 1) * (cooldown + 1) + maxFrequencyTasks);

            return minScheduleLength;
        }

        // RELATIVE RANKS
        public String[] findRelativeRanks(int[] scores) {
            String[] result = new String[scores.length];

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return b[0] - a[0];
                }
            });

            for(int i = 0; i < scores.length; i++) {
                pq.offer(new int[]{scores[i], i});
            }

            for (int rank = 1; rank <= scores.length; rank++) {
                int[] pair = pq.poll();
                int scoreIndex = pair[1]; // This is the original index

                // Step 3: Place the rank string into the correct position in the result array
                if (rank == 1) {
                    result[scoreIndex] = "Gold Medal";
                } else if (rank == 2) {
                    result[scoreIndex] = "Silver Medal";
                } else if (rank == 3) {
                    result[scoreIndex] = "Bronze Medal";
                } else {
                    result[scoreIndex] = String.valueOf(rank);
                }
            }

            return result;

        }

        // MAX PRODUCT OF TWO ELEMENTS IN AN ARRAY
        public int maxProduct(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int num : nums) {
                pq.offer(num);
            }


            return (pq.poll() - 1) * (pq.poll() - 1);
        }
    }
}