package com.leetcode.question;

/**
 * LeetCode4：Median of Two Sorted Arrays
 * 参考：https://blog.csdn.net/zcsylj/article/details/6802062
 */
public class ques4 {
    public static void main(String... args){
        /**
         * 测试用例：
         * num1 = {1,3},num2={2}
         * num1 = {},num2={1}
         * num1 = {},num2 = {2,3}
         * num1 = {1,1,1},num2 = {1,1,1}
         * num1={}
         */

        int[] num1 = {8};
        int[] num2 = {2,3,4,5};


        System.out.println("middle=" + findMedianSortedArrays3(num1,num2));
    }

//    public static double findMedianSortedArrays1(int[] A,int[] B){
//        int m = A.length;
//        int n = B.length;
//        if (m > n) { // to ensure m<=n
//            int[] temp = A; A = B; B = temp;
//            int tmp = m; m = n; n = tmp;
//        }
//        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
//        while (iMin <= iMax) {
//            int i = (iMin + iMax) / 2;
//            int j = halfLen - i;
//            if (i < iMax && B[j-1] > A[i]){
//                iMin = iMin + 1; // i is too small
//            }
//            else if (i > iMin && A[i-1] > B[j]) {
//                iMax = iMax - 1; // i is too big
//            }
//            else { // i is perfect
//                int maxLeft = 0;
//                if (i == 0) { maxLeft = B[j-1]; }
//                else if (j == 0) { maxLeft = A[i-1]; }
//                else { maxLeft = Math.max(A[i-1], B[j-1]); }
//                if ( (m + n) % 2 == 1 ) { return maxLeft; }
//
//                int minRight = 0;
//                if (i == m) { minRight = B[j]; }
//                else if (j == n) { minRight = A[i]; }
//                else { minRight = Math.min(B[j], A[i]); }
//
//                return (maxLeft + minRight) / 2.0;
//            }
//        }
//        return 0.0;
//    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        if (m > n){
            int[] temp = nums1;nums1 = nums2;nums2 = temp;
            int l = n; n = m;m = l;
        }

        int iMin = 0,iMax = m,halfLen = (m+n+1)/2;
        while (iMin <= iMax){
            int i = (iMax+iMin)/2;
            int j = halfLen-i;

            if (i < iMax && nums1[i] < nums2[j-1]){
                iMin = iMin + 1;
            }else if (i > iMin && nums1[i] > nums2[j-1]){
                iMax = iMax -1;
            }else{
                int maxLeft = 0;
                if (i == 0){
                    maxLeft = nums2[j-1];
                }else if (j == 0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }

                if ((m+n)%2 == 1){
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m){
                    minRight = nums2[j];
                }else if (j == n){
                    minRight = nums1[i];
                }else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }

                return (maxLeft+minRight)*1.0/2;

            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0){
            return 0;
        }

        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        //如果第一个数组为空
        if (nums1.length == 0){
            return nums2.length%2 == 0?(nums2[nums2.length/2-1]+nums2[nums2.length/2])*1.0/2:nums2[nums2.length/2];
        }

        if (nums1.length == 1 && nums2.length == 1){
            return (nums1[0]+nums2[0])*1.0/2;
        }else if (nums1.length == 1 && nums2.length == 2) {
            if (nums1[0] > nums2[0]) {
                //第一个数组第一个元素大于第二个数组第一个元素
                if (nums1[0] < nums2[1]) {
                    return nums1[0];
                } else {
                    return nums2[1];
                }
            } else {
                return nums2[0];
            }
        }else{
            if (nums1[nums1.length/2] < nums2[nums2.length/2]){
                return findMedianSortedArrays(getArray(nums1,nums1.length/2,nums1.length),
                        getArray(nums2,0,nums2.length/2));
            }else{
                return findMedianSortedArrays(getArray(nums1,0,nums1.length/2),
                        getArray(nums2,nums2.length/2,nums2.length));
            }
        }
    }

    private static int[] getArray(int[] num,int start,int end){
        if (end-start <= 0){
            return new int[0];
        }
        int[] result = new int[end-start];
        for (int i = 0;i < result.length;i++){
            result[i] = num[start+i];
        }
        return result;
    }
}
