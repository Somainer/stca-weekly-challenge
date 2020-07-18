impl Solution {
    pub fn min_subsequence(mut nums: Vec<i32>) -> Vec<i32> {
        nums.sort_by_key(|&k| std::cmp::Reverse(k));
        let mut result: Vec<i32> = Vec::new();
        let mut rest_sum = nums.iter().sum();
        let mut prev_sum = 0;
        for i in nums {
            result.push(i);
            prev_sum += i;
            rest_sum -= i;
            if prev_sum > rest_sum {
                break;
            }
        }
  
        result
    }
}