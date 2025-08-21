class TwoPointer {
    public static void main(String[] args) {
        // Two Sum || Input is Sorted
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while(left <= right) {
                if(numbers[left] + numbers[right] == target) {
                    left++;
                    right++;
                    return new int[] {left, right};
                }
                if(numbers[left] + numbers[right] > target) {
                    right--;
                }else {
                    left++;
                }
            }
            return new int[] {};
        }
        // Move Zeros
        public void moveZeroes(int[] nums) {
            int j = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    if(i != j) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                    j++;
                }
            }
        }
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

        // Container With Most Water
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int answer = 0;

            while(left < right) {
                int width = right - left;
                int h = Math.min(height[left], height[right]);
                int volume = width * h;

                answer = Math.max(answer, volume);

                if(height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return answer;
        }

        // BACKSPACE STRING COMPARE
        class Solution {
            static int[] fun(String s, int cnt1, int i) {
                while(i >= 0) {
                    if(s.charAt(i) == '#') {
                        cnt1++;
                        i--;
                    }else {
                        if(cnt1 > 0) {
                            cnt1--;
                            i--;
                        }else {
                            break;
                        }
                    }
                }
                return new int[]{cnt1, i};
            }
            public boolean backspaceCompare(String s, String t) {
                int n = s.length();
                int m = t.length();
                int i = n - 1, j = m - 1;
                int cnt1 = 0, cnt2 = 0;
                while(i >= 0 && j >= 0) {
                    int[] arr = fun(s, cnt1, i);
                    cnt1 = arr[0];
                    i = arr[1];

                    arr = fun(t,cnt2,j);
                    cnt2 = arr[0];
                    j = arr[1];

                    if(i < 0 || j < 0) {
                        break;
                    }
                    if(s.charAt(i) != t.charAt(j)) {
                        return false;
                    }
                    i--;
                    j--;
                }

                int[] arr = fun(s, cnt1, i);
                cnt1 = arr[0];
                i = arr[1];

                arr = fun(t, cnt2, j);
                cnt2 = arr[0];
                j = arr[1];

                if(i == -1 && j == -1) {
                    return true;
                }else {
                    return false;
                }
            }
        }
    }
}