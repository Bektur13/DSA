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

        // DELETE GREATEST VALUE IN EACH ROW
        public int deleteGreatestValue(int[][] grid) {
            int ans = 0;

            for (int[] row : grid) {
                Arrays.sort(row);
            }

            for (int j = 0; j < grid[0].length; ++j) {
                int maxOfCurrentOperation = 0;
                for (int i = 0; i < grid.length; ++i) {
                    maxOfCurrentOperation = Math.max(maxOfCurrentOperation, grid[i][j]);
                }
                ans += maxOfCurrentOperation;
            }
            return ans;
        }

        // DESIGN TWITTER
        class Twitter {

            private int timestamp = 0;
            private Map<Integer, List<Tweet>> userTweets;
            private Map<Integer, Set<Integer>> followers;

            private class Tweet {
                int tweetId;
                int timestamp;

                public Tweet(int tweetId, int timestamp) {
                    this.tweetId = tweetId;
                    this.timestamp = timestamp;
                }
            }

            public Twitter() {
                userTweets = new HashMap<>();
                followers = new HashMap<>();
            }

            public void postTweet(int userId, int tweetId) {
                userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, timestamp++));
            }

            public List<Integer> getNewsFeed(int userId) {
                PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);

                if(userTweets.containsKey(userId)) {
                    for(Tweet tweet : userTweets.get(userId)) {
                        pq.offer(tweet);
                        if(pq.size() > 10) {
                            pq.poll();
                        }
                    }
                }

                if(followers.containsKey(userId)) {
                    for (int followeeId : followers.get(userId)) {
                        if (userTweets.containsKey(followeeId)) {
                            for (Tweet tweet : userTweets.get(followeeId)) {
                                pq.offer(tweet);
                                if (pq.size() > 10) {
                                    pq.poll();
                                }
                            }
                        }
                    }
                }

                List<Integer> newsFeed = new LinkedList<>();
                while(!pq.isEmpty()) {
                    newsFeed.addFirst(pq.poll().tweetId);
                }
                return newsFeed;
            }

            public void follow(int followerId, int followeeId) {
                if(followerId == followeeId) return;
                followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
            }

            public void unfollow(int followerId, int followeeId) {
                if (followers.containsKey(followerId)) {
                    followers.get(followerId).remove(followeeId);
                }
            }
        }

        // TOP K FREQUENT WORDS
        class Solution {
            private class MyEntry {
                public String key;
                public int freq;

                public MyEntry(String key, int freq) {
                    this.key = key;
                    this.freq = freq;
                }
            }
            public List<String> topKFrequent(String[] words, int k) {

                HashMap<String, Integer> hm = new HashMap<>();
                for(String word : words) {
                    if(hm.containsKey(word)) {
                        hm.put(word, hm.get(word) + 1);
                    }else {
                        hm.put(word, 1);
                    }
                }

                PriorityQueue<MyEntry> pq = new PriorityQueue<>((a, b) -> {
                    if(a.freq != b.freq) {
                        return a.freq - b.freq;
                    }else {
                        return b.key.compareTo(a.key);
                    }
                });
                for(Map.Entry<String, Integer> entry : hm.entrySet()) {
                    pq.add(new MyEntry(entry.getKey(), entry.getValue()));
                    if(pq.size() > k) {
                        pq.poll();
                    }
                }

                List<String> result = new ArrayList<>();
                while(!pq.isEmpty()) {
                    result.add(pq.poll().key);
                }

                Collections.reverse(result);
                return result;
            }
        }

        // EQUAL SUM ARRAYS WITH MINIMUM NUMBER OF OPERATIONS
        public int minOperations(int[] nums1, int[] nums2) {
            if(nums1.length > nums2.length * 6 ||  nums1.length * 6 < nums2.length) return -1;

            int sum1 = 0;
            int sum2 = 0;
            for(int num : nums1) sum1 += num;
            for(int num : nums2) sum2 += num;

            if(sum1 > sum2) {
                int[] temp = nums1; nums1 = nums2; nums2 = temp;
                int tempSum = sum1; sum1 = sum2; sum2 = tempSum;
            }

            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
            for(int x : nums1) pq1.offer(x);
            for(int x : nums2) pq2.offer(x);

            int operations = 0;
            for(; sum1 < sum2; operations++) {
                if(pq2.isEmpty() || pq2.peek() - 1 < 6 - pq1.peek()) {
                    sum1 += 6 - pq1.poll();
                }else {
                    sum2 -= pq2.poll() - 1;
                }
            }

            return operations;
        }

        // MAKE ARRAY BY ZERO BY SUBSTRACTING EQUAL AMOUNTS
        public int minimumOperations(int[] nums) {
            if(nums.length <= 1 && nums[0] == 0) return 0;

            Set<Integer> s = new HashSet<>();
            for(int num : nums) {
                if(num != 0) {
                    s.add(num);
                }
            }

            return s.size();
        }

        //SORT CHARACTERS BY FREQUENCY
        class Solution {
            private class MyEntry {
                public char key;
                public int freq;

                public MyEntry(char key, int freq) {
                    this.key = key;
                    this.freq = freq;
                }
            }

            public String frequencySort(String s) {

                HashMap<Character, Integer> hm = new HashMap<>();
                for(char c : s.toCharArray()) {
                    hm.put(c, hm.getOrDefault(c, 0) + 1);
                }

                PriorityQueue<MyEntry> pq = new PriorityQueue<>(new Comparator<MyEntry>() {
                    @Override
                    public int compare(MyEntry a, MyEntry b) {
                        return b.freq - a.freq;
                    }
                });
                for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
                    pq.add(new MyEntry(entry.getKey(), entry.getValue()));
                }

                StringBuilder resultBuilder = new StringBuilder();
                while(!pq.isEmpty()) {
                    MyEntry entry = pq.poll();
                    for(int i = 0; i < entry.freq; i++) {
                        resultBuilder.append(entry.key);
                    }
                }

                return resultBuilder.toString();
            }
        }

        // FIND MEDIAN FROM DATA STEAM
        class MedianFinder {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            public MedianFinder() {}

            public void addNum(int num) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());

                if(minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }

            public double findMedian() {
                if(maxHeap.size() > minHeap.size()) {
                    return maxHeap.peek();
                }
                return (minHeap.peek() + maxHeap.peek()) / 2.0d;
            }
        }

        // K CLOSEST POINTS TO ORIGIN
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] p1, int[] p2) {
                    return (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]);
                }
            });

            for(int[] point : points) {
                maxHeap.offer(point);
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }

            int[][] result = new int[k][2];
            for(int i = 0; i < k; i++) {
                result[i] = maxHeap.poll();
            }

            return result;
        }

        // MAXIMUM AVERAGE PASS RATIO
        class Solution {
            public double maxAverageRatio(int[][] classes, int extraStudents) {
                PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
                        Comparator.comparingDouble(o -> -o[0])
                );

                for(int[] c : classes) {
                    double a = c[0], b = c[1];
                    maxHeap.offer(new double[]{profit(a, b), a, b});
                }

                while(extraStudents > 0) {
                    double[] top = maxHeap.poll();
                    double a = top[1], b = top[2];
                    maxHeap.offer(new double[]{profit(a + 1, b + 1), a + 1, b + 1});
                    extraStudents--;
                }

                double ans = 0.0;
                while(!maxHeap.isEmpty()) {
                    double[] top = maxHeap.poll();
                    double a = top[1], b = top[2];
                    ans += a / b;
                }

                return ans / classes.length;
            }

            double profit(double a, double b) {
                return (a + 1) / (b + 1) - a / b;
            }
        }
    }
}