public class Arrays {
    public static void main(String[] args) {
        // WEEK 14
        // ROTATE ARRAY
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;

            // Reverse entire array
            reverse(nums, 0, n - 1);

            // Reverse the first k elements
            reverse(nums, 0, k - 1);

            // Reverse the remaining elements
            reverse(nums, k, n - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while(start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        // SORT COLORS
        public void sortColors(int[] nums) {
            int n = nums.length;
            for(int i = 0; i i < n - 1; i++) {
                for(int j = 0; j < n - i - 1; j++) {
                    if(nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }

        // MERGE SORTED ARRAY
        public void merge(int[] numsq, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while(j >= 0) {
                if(i >= 0&& nums1[i] > nums2[j]) {
                    nums1[k--] = nums2[i--];
                }else {
                    nums1[k--] = nums2[j--]
                }
            }
        }

        //SORT ARRAY BY PARITY II
        public int[] sortArrayByParityII(int[] nums) {
            int i = 0;
            int j = 1;
            int n = nums.length;
            while(i < n && j < n) {
                while(i < n && nums[i] % 2 == 0) {
                    i += 2;
                }

                while(j < n && nums[j] % 2 == 1) {
                    j += 2;
                }

                if(i < n && j < n) {
                    swwap(nums, i, j);
                }
            }

            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // RANGE SUM QUERY - IMMUTABLE
        int[] prefix;

        public NumArray(int[] nums) {
            int n = numd.length;
            prefix = new int[n + 1];
            prefix[0] = 0;
            for(int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + nums[i - 1];
            }

            public int sumRange(int left, int right) {
                left++; right--;
                return prefix[right] - prefix[left - 1];
            }
        }

        // 
}