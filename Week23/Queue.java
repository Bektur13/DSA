public class Queue {
    public static void main(String[] args) {
        // IMPLEMENT QUEUE USING STACKS
        class MyQueue {
            Stack<Integer> input = new Stack();
            Stack<Integer> output = new Stack();

            public void push(int x) {
                input.push(x);
            }

            public int pop() {
                int x = peek();
                output.pop();
                return x;
            }

            public int peek() {
                if(output.empty()) {
                    while(!input.empty()) {
                        output.push(input.pop());
                    }
                }
                return output.peek();
            }

            public boolean empty() {
                return input.empty() && output.empty();
            }
        }

        // DESIGN CIRCULAR QUEUE
        class MyCircularDeque {
            private int[] res;
            private int front, size, capacity;

            public MyCircularDeque(int k) {
                res = new int[k];
                front = 0;
                size = 0;
                capacity = k;
            }

            public boolean insertFront(int value) {
                if(size == capacity) {
                    return false;
                }else {
                    front = (front - 1 + capacity) % capacity;
                    res[front] = value;
                    size++;
                    return true;
                }
            }

            public boolean insertLast(int value) {
                if(size == capacity) {
                    return false;
                }else {
                    int rear = (front + size) % capacity;
                    res[rear] = value;
                    size++;
                    return true;
                }
            }

            public boolean deleteFront() {
                if(size == 0) {
                    return false;
                }else {
                    front = (front + 1) % capacity;
                    size--;
                    return true;
                }
            }

            public boolean deleteLast() {
                if(size == 0) {
                    return false;
                }else {
                    int rear = (front + size - 1) % capacity;
                    size--;
                    return true;
                }
            }

            public int getFront() {
                if(isEmpty()) {
                    return -1;
                }else {
                    return res[front];
                }
            }

            public int getRear() {
                if(isEmpty()) {
                    return -1;
                }else {
                    int rear = (front + size - 1) % capacity;
                    return res[rear];
                }
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public boolean isFull() {
                return size >= capacity;
            }
        }

        // SHORTEST SUBARRAY WITH SUM AT LEAST K
        public int shortestSubarray(int[] nums, int k) {
            int N = nums.length;
            int res = N + 1;

            long[] B = new long[N + 1];
            for(int i = 0; i < N; i++) {
                B[i + 1] = B[i] + nums[i];
            }

            Deque<Integer> d = new ArrayDeque<>();
            for(int i = 0; i < N + 1; i++) {
                while(d.size() > 0 && B[i] - B[d.getFirst()] >= k) {
                    res = Math.min(res, i - d.pollFirst());
                }
                while(d.size() > 0 && B[i] <= B[d.getLast()]) {
                    d.pollLast();
                }
                d.addLast(i);
            }
            return res <= N ? res : -1;
        }

        // SLIDING WINDOW MAXIMUM
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums == null || k <= 0) {
                return new int[0];
            }

            int n = nums.length;
            int[] res = new int[n - k + 1];
            int ri = 0;

            Deque<Integer> d = new ArrayDeque<>();
            for(int i = 0; i < nums.length; i++) {
                while(!d.isEmpty() && d.peekFirst() < i - k + 1) {
                    d.pollFirst();
                }

                while(!d.isEmpty() && nums[i] > nums[d.peekLast()]) {
                    d.pollLast();
                }

                d.offer(i);
                if(i >= k - 1) {
                    res[ri++] = nums[d.peekFirst()];
                }
            }

            return res;
        }

        // LONGEST CONTINIOUS SUBARRAY WITH ABSOLUTE DIFF LESS THAN OR EQUAL TO LIMIT
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> maxDeque = new LinkedList<>();
            Deque<Integer> minDeque = new LinkedList<>();

            int left = 0;
            int maxLength = 0;

            for(int right = 0; right < nums.length; ++right) {
                while(!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) maxDeque.pollLast();
                while(!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) minDeque.pollLast();
                maxDeque.offerLast(nums[right]);
                minDeque.offerLast(nums[right]);

                while(maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                    if(maxDeque.peekFirst() == nums[left]) {
                        maxDeque.pollFirst();
                    }
                    if(minDeque.peekFirst() == nums[left]) {
                        minDeque.pollFirst();
                    }
                    ++left;
                }

                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }
}