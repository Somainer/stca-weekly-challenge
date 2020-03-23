object Solution {
    def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val dx = List(1, 0, -1, 0)
    val dy = List(0, 1, 0, -1)
    def fill(row: Int, col: Int, color: Int): Unit = {
      image(row)(col) = newColor
      for {
        (dx, dy) <- dx.zip(dy)
        i = row + dx
        j = col + dy
        if image lift i flatMap (_ lift j) contains color
      } {
        fill(i, j, color)
      }
    }
    val color = image(sr)(sc)
    if (color == newColor) image
    else {
      fill(sr, sc, color)
      image
    }
  }
}