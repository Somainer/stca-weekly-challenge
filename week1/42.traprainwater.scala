object Solution {
    def trap(height: Array[Int]): Int =
      height.scan(0)(_ max _)
        .drop(1)
        .zip(height.scanRight(0)(_ max _).dropRight(1))
        .map(Function.tupled(_ min _)).sum - height.sum
}