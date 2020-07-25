impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        let mut res = 0;
        for (i, &x) in nums.iter().enumerate() {
            res ^= i as i32;
            res ^= x;
        }
        res ^ nums.len() as i32
    }
}