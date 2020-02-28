object Solution {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val shouldRotateRowNum = (matrix.length >> 1) + (matrix.length & 1)
    if (matrix.nonEmpty) 0 until shouldRotateRowNum foreach { up =>

      val down = matrix.length - up - 1
      0 until (down - up) foreach { i =>
        val a = matrix(up)(i + up)
        val b = matrix(i + up)(down)
        val c = matrix(down)(down - i)
        val d = matrix(down - i)(up)
        matrix(up)(i + up) = d
        matrix(i + up)(down) = a
        matrix(down)(down - i) = b
        matrix(down - i)(up) = c
      }
    }
  }
}