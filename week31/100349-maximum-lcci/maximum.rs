impl Solution {
    pub fn maximum(a: i32, b: i32) -> i32 {
        vec![a, b][((a as i64 - b as i64) as u64 >> 63) as usize]
    }
}