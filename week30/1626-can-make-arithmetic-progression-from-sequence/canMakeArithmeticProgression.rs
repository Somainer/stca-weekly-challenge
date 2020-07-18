impl Solution {
    pub fn can_make_arithmetic_progression(mut arr: Vec<i32>) -> bool {
        arr.sort();
        if arr.len() < 2 {
            true
        } else {
            let first = arr[0];
            let second = arr[1];
            let diff = first - second;
            arr.iter()
                .zip(arr.iter().skip(1))
                .all(|(&a, &b)| a - b == diff)
        }
    }
}
