impl Solution {
    pub fn bit_count(mut x: i32) -> i32 {
        let mut count = 0;
        while x > 0 {
            count += x & 1;
            x >>= 1;
        }
        count
    }
    pub fn hamming_distance(x: i32, y: i32) -> i32 {
        Self::bit_count(x ^ y)        
    }
}