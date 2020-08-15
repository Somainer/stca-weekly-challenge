impl Solution {
    pub fn reverse_words(s: String) -> String {
        let parts: Vec<_> = s.split(' ').filter(|s| !s.is_empty()).rev().collect();
        parts.join(" ")
    }
}
