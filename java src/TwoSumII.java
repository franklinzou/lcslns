/*
 * Tag: Two Pointers
 * Tag: Array
 * Tag: Binary Search
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // two pointer method
        int len = numbers.length;
        int l = 0, r = len - 1;
        int [] res = new int[2];
        // we guarantee for any i in [S..l-1] or [r+1..E], nums[i] is a bad partner (for any j in [S..E], nums[i] + nums[j] != target)
        while(l < r){
            if(numbers[l] + numbers[r] < target) l++;
            else if(numbers[l] + numbers[r] > target) r--;
            else{
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }
        }
        
        return res;
        // TODO: binary search method
    }
}