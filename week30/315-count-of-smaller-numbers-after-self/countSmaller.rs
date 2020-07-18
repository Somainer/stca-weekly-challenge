impl Solution {
    pub fn count_smaller(nums: Vec<i32>) -> Vec<i32> {
        let mut sorted_nums = nums.clone();
        sorted_nums.sort();
        let mut bits = vec![0; nums.len() + 1];
        let mut result: Vec<i32> = nums.iter()
            .rev()
            .map(|x| sorted_nums.binary_search(x).unwrap() + 1)
            .map(|x| {
                incr(&mut bits, x);
                if x == 1 { 0 }
                else { range_sum(&bits, x - 1) }
            })
            .collect();
        result.reverse();
        result
    }
}

fn lowbit(x: usize) -> usize {
    x & (!x + 1)
}

fn incr(bits: &mut Vec<i32>, index: usize) {
    let mut idx = index;
    let length = bits.len();
    while idx < length {
        bits[idx] += 1;
        idx += lowbit(idx);
    }
}

fn range_sum(bits: &Vec<i32>, until: usize) -> i32 {
    let mut idx = until;
    let mut sum: i32 = 0;
    while idx > 0 {
        sum += bits[idx];
        idx -= lowbit(idx);
    }
    sum
}
