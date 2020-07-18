impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        let mut low = 0;
        let mut high: i32 = nums.len() as i32 - 1;
        let mut i = 0;
        while i <= high {
            if nums[i as usize] == 0 {
                nums.swap(low, i as usize);
                low += 1;
                i += 1;
            } else if nums[i as usize] == 1 {
                i += 1;
            } else {
                nums.swap(i as usize, high as usize);
                high -= 1;
            }
        }
    }
}
