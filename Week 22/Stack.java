public class Stack {
    public static void main(String[] args) {
        // VALID PARENTHESES
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for(char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if(stack.isEmpty() || !match(stack.pop(), c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        public boolean match(char open, char close) {
            return (open == '(' && close == ')') ||
                    (open == '{' && close == '}') ||
                    (open == '[' && close == ']');
        }

        // EVALUATE REVERSE POLISH NOTATION
        public int evalRPN(String[] tokens) {

            Stack<Integer> stack = new Stack<>();
            int result = 0;

            for(int i = 0; i < tokens.length; i++) {
                if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*") ) {
                    int second = stack.pop();
                    int first = stack.pop();
                    if(tokens[i].equals("+")) {
                        result = first + second;
                        stack.push(result);
                    }else if(tokens[i].equals("-")) {
                        result = first - second;
                        stack.push(result);
                    }else if(tokens[i].equals("/")) {
                        result = first / second;
                        stack.push(result);
                    }else{
                        result = first * second;
                        stack.push(result);
                    }

                } else {
                    Integer number = Integer.parseInt(tokens[i]);
                    stack.push(number);
                }
            }

            return stack.pop();
        }

        // DAILY TEMPERATURES
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] result = new int[n];

            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n - 1; i++) {
                if(temperatures[i] < temperatures[i + 1]) {
                    result[i] = 1;
                    while(!stack.isEmpty() && temperatures[i + 1] > temperatures[stack.peek()]) {
                        result[stack.peek()] = i + 1 - stack.peek();
                        stack.pop();
                    }
                }else {
                    stack.push(i);
                }
            }
            return result;
        }

        // LARGEST RECTANGLE IN HISTOGRAM
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0;
            int n = heights.length;

            for (int i = 0; i <= n; i++) {
                // Get the current height, considering a virtual bar of height 0 at the end
                // to process remaining bars in the stack.
                int currentHeight = (i == n) ? 0 : heights[i];

                // While the stack is not empty and the current height is less than or equal
                // to the height of the bar at the top of the stack, process the popped bar.
                while (!stack.isEmpty() && currentHeight <= heights[stack.peek()]) {
                    int poppedHeightIndex = stack.pop();
                    int poppedHeight = heights[poppedHeightIndex];

                    // Calculate the width of the rectangle formed by the popped bar.
                    // If the stack is empty, the width extends to the current index 'i'.
                    // Otherwise, the width is from the element before the current top of the stack
                    // to the current index 'i'.
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                    maxArea = Math.max(maxArea, poppedHeight * width);
                }
                // Push the current index onto the stack.
                stack.push(i);
            }
            return maxArea;
        }

        // MIN STACK
        class MinStack {
            List<Integer> data;
            List<Integer> minData;

            public MinStack() {
                data = new ArrayList<>();
                minData = new ArrayList<>();
            }

            public void push(int val) {
                data.add(val);
                if(minData.isEmpty() || minData.get(minData.size() - 1) >= val) {
                    minData.add(val);
                }else {
                    minData.add(minData.get(minData.size() - 1));
                }
            }

            public void pop() {
                data.remove(data.size() - 1);
                minData.remove(minData.size() - 1);
            }

            public int top() {
                return data.get(data.size() - 1);
            }

            public int getMin() {
                return minData.get(minData.size() - 1);
            }
        }

    }
}