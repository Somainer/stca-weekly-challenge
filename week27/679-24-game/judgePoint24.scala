object Solution {
  def judgePoint24(nums: Array[Int]): Boolean = {
    val eps = 1e-3
    @inline def is24(x: Double): Boolean = (x - 24.0).abs < eps
    val ops: List[(Double, Double) => Double] = List(
      _ + _, _ - _, _ * _, _ / _
    )
    val combs = for {
      x <- ops
      y <- ops
      z <- ops
    } yield (x, y, z)
    nums.sorted.permutations.exists { case Array(a, b, c, d) =>
      combs.exists { case (fx, fy, fz) =>
        is24(fx(fy(fz(a, b), c), d)) ||
        is24(fx(a, fy(b, fz(c, d)))) ||
        is24(fx(fy(a, b), fz(c, d))) ||
        is24(fx(fy(a, fz(b, c)), d)) ||
        is24(fx(a, fy(fz(b, c), d)))
      }
    }
  }
}