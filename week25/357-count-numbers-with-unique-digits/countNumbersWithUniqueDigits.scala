object Solution {
  def countNumbersWithUniqueDigits(n: Int): Int = {
    if (n == 0) 1
    else if (n == 1) 10
    else (9 +: (1 to 9).reverse).take(n).product + countNumbersWithUniqueDigits(n - 1)
  }
}
