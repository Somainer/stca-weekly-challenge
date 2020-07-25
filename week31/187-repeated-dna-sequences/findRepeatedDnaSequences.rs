impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        use std::collections::HashMap;
        let gene_map: HashMap<char, i32> =
            ['A', 'T', 'C', 'G'].iter().enumerate().map(|(x, &y)| (y, x as i32)).collect();
        let mut occur = HashMap::new();
        let mut result: Vec<String> = vec![];
        let mut last = 0;
        for (i, c) in s.chars().enumerate() {
            last = (last << 2) & 0xfffff | gene_map[&c];
            if i >= 9 {
                let entry = occur.entry(last).or_insert(0);
                *entry += 1;
                if *entry == 2 {
                    result.push(s[(i - 9) as usize..(i + 1) as usize].to_string());
                }
            }
        }
        result
    }
}