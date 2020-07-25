impl Solution {
    pub fn count_usage(words: &Vec<String>, set: usize) -> Vec<i32> {
        let mut result = vec![0; 26];
        for (index, word) in words.iter().enumerate() {
            if (1 << index) & set != 0 {
                for c in word.chars() {
                    result[c as usize - 'a' as usize] += 1;
                }
            }
        }
        result
    }

    pub fn get_score(usages: &Vec<i32>, scores: &Vec<i32>, available: &Vec<i32>) -> Option<i32> {
        let mut score = 0;
        for (letter, &count) in usages.iter().enumerate() {
            if count > available[letter] {
                return None
            }
            score += scores[letter] * count;
        }
        Some(score)
    }

    pub fn max_score_words(words: Vec<String>, letters: Vec<char>, score: Vec<i32>) -> i32 {
        let available_counts = {
            let mut counts = vec![0; 26];
            for c in letters {
                counts[c as usize - 'a' as usize] += 1;
            }
            counts
        };
        (0..(1 << words.len())).flat_map(|set| {
            let usages = Self::count_usage(&words, set);
            Self::get_score(&usages, &score, &available_counts)
        }).max().unwrap_or(0)
    }
}