class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> ans;
        if (nums.size() < 4)
            return ans;
        sort(nums.begin(), nums.end());
        for (int a = 0; a + 3 < nums.size(); ++a) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (int i = a + 1; i + 1 < nums.size(); ++i) {
                int n = nums[i];
                if (i > a + 1 && nums[i] == nums[i - 1])
                    continue;
                int left = i + 1, right = nums.size() - 1;
                while (left < right) {
                    int sumDiff = n + nums[left] + nums[right] + nums[a] - target;
                    if (0 == sumDiff) {
                        ans.push_back(vector<int>{nums[a], n, nums[left], nums[right]});
                        while (left < right && nums[left] == nums[left + 1])
                            ++left;
                        while (left < right && nums[right] == nums[right - 1])
                            --right;
                        ++left;
                        --right;
                    }
                    else if (sumDiff < 0) {
                        ++left;
                    } else --right;
                }
            }
        }
        return ans;
    }
};