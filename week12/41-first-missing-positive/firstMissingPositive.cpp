class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        for (int i = 0; i < nums.size();) {
            int x = nums[i];
            if (x == i + 1 || x <= 0 || x > nums.size() || nums[x - 1] == x) ++i;
            else swap(nums[x - 1], nums[i]);
        }
        for (int i = 1; i <= nums.size(); ++i) {
            if (i != nums[i - 1]) return i;
        }
        return nums.size() + 1;
    }
};