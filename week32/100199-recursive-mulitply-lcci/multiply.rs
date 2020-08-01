impl Solution {
    pub fn multiply(a: i32, b: i32) -> i32 {
        if b == 0 {
            0
        } else if b & 1 == 1 {
            Self::multiply(a << 1, b >> 1) + a
        } else {
            Self::multiply(a << 1, b >> 1)
        }
    }
}
