impl Solution {
    pub fn min_swaps_couples(mut row: Vec<i32>) -> i32 {
        fn find_pair(p: i32) -> i32 {
            if p & 1 == 1 { p - 1 } else { p + 1 }
        }
        let mut swap_count = 0;
        for i in (0..row.len()).step_by(2) {
            let p1 = row[i];
            let p2 = find_pair(p1);
            if p2 != row[i + 1] {
                let to_swap = row.iter().position(|&x| x == p2).unwrap();
                row.swap(to_swap, i + 1);
                swap_count += 1;
            }
        }
        swap_count
    }
}
