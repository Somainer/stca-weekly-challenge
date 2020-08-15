impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        nums.iter().fold((0, 0), |(last, occur), &this| {
            if last == this { (this, occur + 1) }
            else {
                let current = occur - 1;
                if occur <= 0 { (this, 1) }
                else { (last, current) }
            }
        }).0
    }
}
