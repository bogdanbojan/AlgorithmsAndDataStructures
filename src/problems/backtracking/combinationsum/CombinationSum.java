package problems.backtracking.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /*

    l = [1];     t = 2 -> o : [1,1]
    l = [2,3,5]; t = 8 -> o : [2,2,2,2],[3,3,2],[3,5]


    2 - 1 = 1
    1 - 1 = 0
    [1,1]


    8 - 2 = 6
    6 - 2 = 4
    4 - 2 = 2
    2 - 2 = 0
    [2,2,2,2]


    6 - 3 = 3 // continues i from first method call
    3 - 3 = 0

    [2,3,3]

    3,5

     */




    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i+1); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
