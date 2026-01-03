class Reverse_String_Prefix {
    public String reversePrefix(String s, int k) {
        char []lett = s.toCharArray();
        int l = 0;
        int r = k - 1;

        while(l < r){
            char ch = lett[l];
            lett[l] = lett[r];
            lett[r] = ch;
            l++;
            r--;
        }
        return new String(lett);
    }
}