object Solution {
  def numEquivDominoPairs(dominoes: Array[Array[Int]]): Int = {
    dominoes.map {
      case Array(x, y) => if (x < y) ((x << 4) | y) else ((y << 4) | x)
    }.foldLeft(Map.empty[Int, Int]) {
      case (m, x) => m.updatedWith(x)(_.orElse(Some(0)).map(1.+))
    }.values.map(x => x * (x - 1) >> 1).sum
  }
}