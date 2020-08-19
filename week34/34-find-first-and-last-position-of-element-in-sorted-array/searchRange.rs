impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        fn search_bounds<T>(xs: &Vec<T>, target: &T, cmp: fn(&T, &T) -> bool) -> usize {
            let (mut left, mut right) = (0, xs.len());
            while left < right {
                let mid = (left + right) >> 1;
                if cmp(&xs[mid], target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            left
        }

        let lower_bound = search_bounds(&nums, &target, i32::lt);
        if lower_bound == nums.len() || nums[lower_bound] != target { 
            vec![-1, -1]
        } else {
            vec![
                lower_bound as i32,
                search_bounds(&nums, &target, i32::le) as i32 - 1
            ]
        }
    }
}
