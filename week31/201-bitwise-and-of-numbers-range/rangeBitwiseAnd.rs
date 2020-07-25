impl Solution {
    pub fn range_bitwise_and(mut m: i32, mut n: i32) -> i32 {
        let mut count = 0;
        while m != n {
            m >>= 1;
            n >>= 1;
            count += 1;
        }
        // Higher bits are not changed, just shift.
        m << count
    }
}