impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        let mut y = x as i64;
        while y * y > x as i64 {
            y = (y + x as i64 / y) >> 1;
        }
        y as i32
    }
}