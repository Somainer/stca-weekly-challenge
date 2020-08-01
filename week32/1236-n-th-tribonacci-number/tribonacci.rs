impl Solution {
    pub fn tribonacci(n: i32) -> i32 {
        fn tribonacci_tailrec(n: i32, a: i32, b: i32, c: i32) -> i32 {
            if n < 3 {
                [a, b, c][n as usize]
            } else {
                tribonacci_tailrec(n - 1, b, c, a + b + c)
            }
        }
        tribonacci_tailrec(n, 0, 1, 1)
    }
}
