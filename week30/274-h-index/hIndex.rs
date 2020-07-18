impl Solution {
    pub fn h_index(mut citations: Vec<i32>) -> i32 {
        citations.sort();
        citations
            .iter()
            .enumerate()
            .find_map(|(i, &x)| {
                let h = (citations.len() - i) as i32;
                Some(h).filter(|&v| v <= x)
            })
            .unwrap_or(0)
    }
}
