/*
 * Intersection of Two Arrays
 * Tag: Binary Search
 * Tag: Hash Table
 * Tag: Two Pointers
 * Tag: Sort
 */
import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        /*
        // two-pointer based method
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, p1 = 0;
        int len2 = nums2.length, p2 = 0;
        ArrayList<Integer> resList = new ArrayList<Integer>();
        //we guarantee each number in nums1[S..p1 - 1] and nums2[S..p2-1] has been checked for its partner
        while(p1 < len1 && p2 < len2){
            if(p1 != 0 && nums1[p1] == nums1[p1 - 1]) p1++;
            else if(nums1[p1] == nums2[p2]){
                resList.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2]) p1++;
            else p2++;
        }
        int [] res = new int[resList.size()];
        int ind = 0;
        for(int num : resList) res[ind++] = num;
        return res;
        */
        // binary search based method
        // sort the first array, and then apply binary search for values in the second array 
        Arrays.sort(nums1);
        Set<Integer> s = new HashSet<Integer>(); // use set to avoid duplicate
        for(int num : nums2)
            if(binSearch(nums1, num)) s.add(num);

        int [] res = new int[s.size()];
        int ind = 0;
        for(int val : s) res[ind ++] = val;
        return res;
        // TODO: hashmap based method
    }
    
    private boolean binSearch(int nums[], int target){
        int n = nums.length, l = 0, r = n - 1;
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            if(nums[m] == target) return true;
            else if(nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}