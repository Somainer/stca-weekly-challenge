object Solution {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    @annotation.tailrec
    def search(left: Int, right: Int): Array[Int] = {
      val sum = numbers(left) + numbers(right)
      if (sum == target) Array(left, right)
      else if (sum < target) search(left + 1, right)
      else search(left, right - 1)
    }
    search(0, numbers.length - 1).map(_ + 1)
  }
}