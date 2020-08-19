impl Solution {
    pub fn find_magic_index(nums: Vec<i32>) -> i32 {
        nums.iter().enumerate()
            .find(|&(i, &x)| i as i32  == x)
            .map(|(i, &x)| x).unwrap_or(-1)
    }
}
