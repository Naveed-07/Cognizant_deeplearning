package array;

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i-- ) {
            if(digits[i] < 9){
               digits[i] ++;
               return digits;
            }
            digits[i] = 0;
        }
        digits = new int [digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

// test case
//if digits == [1,2,3] ---> add one on last index and give [1,2,4]
//if digits == [9] ---> add one and give last index [1,0]