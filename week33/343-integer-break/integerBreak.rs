impl Solution {
    /// LeetCode 343
    ///
    /// $n = a_1 + a_2 + a_3 + ... + a_m (n \in [2, 58],m \geq 2)$
    /// Find the maxium value of $ f = a_1  a_2 a_3 ... a_m $.
    /// Obviously if and only if $ a_1 = a_2 = ... a_m $, $f$ gots the maxium value.
    /// So $n = a * m$ where $a = a_1 = a_2 = ... = a_m$. 
    /// $f(a) = a ^ {\frac{n}{a}} = e^{\frac{n}{a} \ln{a}}$. The derivative of f is 
    /// $f' = n e^{\frac{n}{a}\ln{a}}(\frac{1 - \ln{a}}{a^2})$ let $f' = 0$, $a = e$. 
    /// Thus if and only if each element is $e$, the product of them gets the maxium value. 
    /// Regarding each element $a$ is a positive integer, $a = 3$. 
    pub fn integer_break(n: i32) -> i32 {
        if n == 2 {
            return 1;
        }
        if n == 3 {
            return 2;
        }
        let mut result = 1;
        let mut current = n;
        while current > 0 {
            if current <= 4 {
                result *= current;
                current = 0;
            } else {
                result *= 3;
                current -= 3;
            }
        }
        result
    }
}
