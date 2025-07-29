class TwoPointer {
    public static void main(String[] args) {
        // String Compression
        public int compress(char[] chars) {
            int n = chars.length;

            int streakStart = 0;
            int indexAnswer = 0;
            while(streakStart < n) {
                char streakChar = chars[streakStart];
                int streakEnd = streakStart;
                int count = 1;
                while(streakEnd + 1 < n && chars[streakEnd + 1] == streakChar) {
                    streakEnd++;
                    count++;
                }

                chars[indexAnswer] = streakChar;
                indexAnswer++;

                if(count > 1) {
                    char[] countAsChar = Integer.toString(count).toCharArray();
                    for(char digit : countAsChar) {
                        chars[indexAnswer] = digit;
                        indexAnswer++;
                    }
                }
                streakStart = streakEnd + 1;
            }
            return indexAnswer;
        }
    }
}