impl Solution {
    pub fn str_to_int(str: String) -> i32 {
        let s = str.trim();
        if s.is_empty() {
            0
        } else {
            let mut iterator = s.chars().peekable();
            let mut neg = false;
            let mut num: i64 = 0;
            if let Some('-') = iterator.peek() {
                neg = !neg;
                iterator.next();
            } else if let Some('+') = iterator.peek() {
                iterator.next();
            }
            while let Some(ch) = iterator.next() {
                if !ch.is_ascii_digit() {
                    break;
                }
                num = (num * 10) + ((ch as i64 - '0' as i64));
                if num > (i32::max_value()) as i64 {
                    return if neg { i32::min_value() } else { i32::max_value() };
                }
            }
            (if neg { -num } else { num }) as i32
        }
    }
}
