class Find_Maximum_Value_In_A_Constrained_Sequence {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {

        int[] new_arr = diff; 

        long[] cap = new long[n];
        Arrays.fill(cap, Long.MAX_VALUE);

        cap[0] = 0;

        for (int i = 0; i < restrictions.length; i++) {
            int pos = restrictions[i][0];
            int lim = restrictions[i][1];
            cap[pos] = Math.min(cap[pos], lim);
        }

        for (int i = 1; i < n; i++) {
            cap[i] = Math.min(cap[i], cap[i - 1] + new_arr[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            cap[i] = Math.min(cap[i], cap[i + 1] + new_arr[i]);
        }

        long best = 0;
        for (long v : cap) {
            if (v > best) best = v;
        }

        return (int) best;

    }
}
