class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        // Start the backtracking process with an empty temp list
        backtrack(resultList, new ArrayList<>(), nums);

        return resultList;
    }

    public void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums){
        // ✅ BASE CASE: if tempList size == nums length, we found a permutation
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));  // Add a COPY of current permutation
            return;
        }

        // 🔁 Try adding each number one by one
        for(int number : nums){
            // ⛔ Skip if number already exists (so no duplicates)
            if(tempList.contains(number))
                continue;

            // ✅ Choose: Add number to current permutation
            tempList.add(number);

            // 🔁 Explore further with the current choice
            backtrack(resultList, tempList, nums);

            // 🔙 Backtrack: Remove last added number to try a different option
            tempList.remove(tempList.size() - 1);
        }
    }
}
