impl Solution {
    pub fn find_longest_word(s: String, mut d: Vec<String>) -> String {
        d.sort_by(|a, b| {
            if a.len() != b.len() {
                b.len().cmp(&a.len())
            } else {
                a.cmp(&b)
            }
        });
  
        d.iter().find(|&t| {
            let mut jit = t.chars().peekable();
            for c in s.chars() {
                match jit.peek() {
                    Some(&x) if x == c => { jit.next(); },
                    _ => ()
                }
            }
            jit.next().is_none()
        }).cloned().unwrap_or("".to_string())
    }
 }