impl Solution {
    pub fn find_closest_elements(arr: Vec<i32>, k: i32, x: i32) -> Vec<i32> {
        let ks = k as usize;
        let (mut begin, mut end) = (0, arr.len() - ks);
        while begin < end {
            let mid = (begin + end) >> 1;
            if x - arr[mid] > arr[mid + ks] - x {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        arr[begin..begin + ks].to_vec()
    }
}
