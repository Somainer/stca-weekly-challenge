impl Solution {
    pub fn diving_board(shorter: i32, longer: i32, k: i32) -> Vec<i32> {
        if k == 0 {
            vec![]
        } else if shorter == longer {
            vec![shorter * k]
        } else {
            (shorter * k ..= longer * k).step_by(longer as usize - shorter as usize).collect()
        }
    }
}
