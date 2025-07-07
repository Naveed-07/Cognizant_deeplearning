package array;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int Sort = m + n -1;

        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[Sort--] = nums1[p1 --];
            } else {
                nums1[Sort--] = nums2[p2 --];
            }
        }
    }
}

//test case 
//nums1 = [1,2,2,4,0,0] m = 4, nums2= [2,6,6] n = 3 , k = m + n 
//output = [1,2,2,2,4,6,6] sorted manner