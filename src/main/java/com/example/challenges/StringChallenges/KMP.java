package com.example.challenges.StringChallenges;

public class KMP {
    /**
     * index:  0  1  2  3  4  5
     * s:      a  b  a  b  a  a
     * next:  -1 -1  0  1  2  0
     * @param next
     * @param s
     */
    public void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;
        for (int i = 0; i<s.length();i++){
            while (j>=0 && s.charAt(i) != s.charAt(j+1)){
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j+1)){
                j++;
                next[i] = j;
            }
        }
    }
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i=0; i<haystack.length();i++){
            while (j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if (j == needle.length()){
                return (i-needle.length()+1);
            }
        }

        return -1;
    }

    public boolean repeatedSubstringPattern(String s){
        if (s.isEmpty()) return false;
        int len = s.length();
        int[] next = new int[s.length()];
        getNext(next, s);
        if (next[len-1] > 0 && len % (len - next[len-1])==0){
            return true;
        }
        return false;
    }
}
