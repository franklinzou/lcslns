/*
 * Intersection of Two Arrays II
 * Tag: Binary Search
 * Tag: Hash Table
 * Tag: Two Pointers
 * Tag: Sort
 */
import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        // two pointer based method - actually use dfs idea
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, p1 = 0;
        int len2 = nums2.length, p2 = 0;
        ArrayList<Integer> resList = new ArrayList<Integer>();
        while(p1 < len1 && p2 < len2){
            if(nums1[p1] < nums2[p2]) p1++;
            else if(nums1[p1] > nums2[p2]) p2++;
            else{
                resList.add(nums1[p1]);
                p1++;
                p2++;
            }
            // we guarantee f(nums1[_p1..E], nums2[_p2..E]) = par_res + f(nums1[p1..E], nums2[p2..E])
        }
        int [] res = new int[resList.size()];
        int ind = 0;
        for(int num : resList) res[ind++] = num;
        return res;
        
        // TODO: hash map based method
        
        // TODO: binary search based method
    }
}