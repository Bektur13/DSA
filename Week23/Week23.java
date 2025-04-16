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
}