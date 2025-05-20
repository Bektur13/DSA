import java.util.Stack;

public class Week23 {
    public static void main(String[] args) {
        // Example usage
        MyQueue queue = new MyQueue();
        queue.push(10);
    }

    // IMPLEMENTING QUEUE USING STACK
    static class MyQueue {
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> output = new Stack<Integer>();

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            int x = peek();
            output.pop();
            return x;
        }

        public int peek() {
            if(output.isEmpty()) {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean isEmpty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    //CONTAINS DUPLICATE 
    public void duplicateZeros(int[] arr) {
       int n = arr.length;
        int zeros = 0;

        // Count the number of zeros
        for (int num : arr) {
            if (num == 0) {
                zeros++;
            }
        }

        // Calculate the potential length of the modified array
        int possibleEnd = n + zeros;

        // Iterate backwards from the end of the original array
        for (int i = n - 1, j = possibleEnd - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i] != 0) {
                // If it's not a zero, copy it to the new position
                if (j < n) {
                    arr[j] = arr[i];
                }
            } else {
                // If it's a zero, copy a zero to the new position
                if (j < n) {
                    arr[j] = 0;
                }
                j--; // Move the pointer for the second zero
                if (j < n) {
                    arr[j] = 0;
                }
            }
        }
    }
}
