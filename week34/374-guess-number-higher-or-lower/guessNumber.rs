/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * unsafe fn guess(num: i32) -> i32 {}
 */

impl Solution {
    unsafe fn guessNumber(n: i32) -> i32 {
        unsafe fn guess_number_in(from: i32, to: i32) -> i32 {
            let mid = from + ((to - from) >> 1);
            match guess(mid) { 
                0 => mid,
                -1 => guess_number_in(from, mid - 1),
                1 => guess_number_in(mid + 1, to),
                _ => panic!()
            }
        }
        guess_number_in(1, n)
    }
}
