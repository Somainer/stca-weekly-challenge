object Solution {
  def isStraight(nums: Array[Int]): Boolean = {
    val nonKings = nums.filter(0.!=)
    val kingsNum = nums.length - nonKings.length
    val (finale, kings) = nonKings.sorted.foldLeft((0, kingsNum)) {
      case ((_, kingsNum), _) if kingsNum < 0 => (-1, 0)
      case ((0, kingsNum), n) => (n, kingsNum)
      case ((-1, kingsNum), _) => (-1, 0)
      case ((last, kingsNum), n) if last + 1 == n => (n, kingsNum)
      case ((last, kingsNum), n) if last != n => (n, kingsNum - (n - last - 1))
      case _ => (-1, 0)
    }
    finale > 0 && kings >= 0
  }
}