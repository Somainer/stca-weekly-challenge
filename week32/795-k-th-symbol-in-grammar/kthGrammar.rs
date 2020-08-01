impl Solution {
    pub fn kth_grammar(n: i32, k: i32) -> i32 {
        if n == 1 { 0 }
        else { 
            Self::kth_grammar(n - 1, (k + 1) >> 1) ^ (k & 1 ^ 1)
        }
    }
}
