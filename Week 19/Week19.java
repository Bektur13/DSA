public class Week19 {
    public static void main(String[] args) {
        private static class Solution {
            hanoi(2, 1, 3);
        }


        // Fibonacci number
        private int[] f;
        public int fib_(int n) {
            if(n <= 1) return n;
            if(f[n] == 0) {
                f[n] = fib_(n - 1) + fib_(n - 2);
            }
            return fib[n];
        }
        public int fib(int n) {
            f = new int[n + 1];
            return fib_(n);
        }

        // Pow(x, n)
        public double myPow(double x, int n) {
            long exponent = (long) n;
            if(exponent < 0) {
                exponent = -exponent;
                x = 1/x;
            }
            return myPow_(x, exponent);
        }
        public double myPow_(double x, long exponent) {
            if(exponent == 0) return 1;

            return (exponent % 2 == 0) ? myPow_(x * x, exponent / 2) : myPow_(x * x, exponent / 2) * x;
        }

        // Tower of Hanoi
        private void hanoi(int n, int from, int to) {
            if(n == 0) return;
            int aux = (1 + 2 + 3) - (from + to);
            hanoi(n - 1, from, aux);
            System.out.prinln(n + "" + from + "" + to);
            hanoi(n - 1, aux, to);
        }
    }
}