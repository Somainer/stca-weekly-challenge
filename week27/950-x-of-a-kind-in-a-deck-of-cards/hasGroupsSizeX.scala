object Solution {
  def hasGroupsSizeX(deck: Array[Int]): Boolean = {
    @annotation.tailrec def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    deck.foldLeft(Map.empty[Int, Int]) {
      case (s, i) => s.updatedWith(i)(_.orElse(Some(0)).map(_ + 1))
    }.values.reduce(gcd) > 1
  }
}