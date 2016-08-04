/*
 * Two Sum II - Input array is sorted
 * Tag: Two Pointers
 * Tag: Array
 * Tag: Binary Search
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        /*
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
        */
        // TODO: binary search method
        int n = numbers.length;
        int [] res = new int[2];
        for(int i = 0; i <= n - 2; i++){
            int counterPart = binSearch(numbers, i + 1, n - 1, target - numbers[i]);
            if(counterPart != -1){
                res[0] = i + 1;
                res[1] = counterPart + 1;
                break;
            }
        }
        return res;
    }
    
    private int binSearch(int [] nums, int s, int e, int target){
        int l = s, r = e;
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            if(nums[m] == target) return m;
            else if(nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}