impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        let mut num = nums[0];
        let mut count = 0;
        for x in nums {
            if num == x {
                count += 1;
            } else {
                if count <= 0 {
                    num = x;
                    count = 0;
                } else {
                    count -= 1;
                }
            }
        }
        num
    }
}