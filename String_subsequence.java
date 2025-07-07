package array;

class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int i = 0, j = 0;
        while( i < sArr.length && j < tArr.length){
            if(sArr[i] == tArr[j]) i++;
            j++;
        }
        return i == sArr.length;
    }
}