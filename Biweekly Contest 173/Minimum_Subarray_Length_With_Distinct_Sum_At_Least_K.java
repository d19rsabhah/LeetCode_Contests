class Minimum_Subarray_Length_With_Distinct_Sum_At_Least_K {
    public int minLength(int[] nums, int k) {
        int []new_arr = nums;
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        long distSum = 0;
        int l = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int x = new_arr[i];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if(freq.get(x) == 1){
                distSum += x;
            }

            while(distSum >= k && l <= i){
                ans = Math.min(ans, i - l + 1);

                int remove = new_arr[l];
                freq.put(remove, freq.get(remove) - 1);
                if(freq.get(remove) == 0){
                    distSum -= remove;
                }
                l++;
            }
        }

        int res = ans == Integer.MAX_VALUE ? -1 : ans;
        return res;
    }
}