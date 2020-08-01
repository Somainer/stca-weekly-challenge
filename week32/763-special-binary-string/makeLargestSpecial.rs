impl Solution {
    pub fn make_largest_special(s: String) -> String {
        if s.is_empty() { "".to_string() }
        else {
            let mut pair_count = 0;
            let mut last_start = 0;
            let mut pairs = vec![];
            for (index, c) in s.char_indices() {
                match c {
                    '0' => pair_count += 1,
                    '1' => pair_count -= 1,
                    _ => {}
                };
                if pair_count == 0 {
                    let segment = &s[last_start + 1..index];
                    let segment_largest = Self::make_largest_special(segment.to_string());
                    pairs.push(format!("1{}0", segment_largest));
                    last_start = index + 1;
                }
            }
            pairs.sort_unstable_by(| a, b | b.cmp(a));
            pairs.join("")
        }
    }
}
