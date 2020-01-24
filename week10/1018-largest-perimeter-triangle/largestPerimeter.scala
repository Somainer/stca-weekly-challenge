object Solution {
  def largestPerimeter(A: Array[Int]): Int = {
    val a = A.sortBy(-_).view
    val b = a.tail
    val c = b.tail
    
    (a zip b zip c).collectFirst {
      case ((x, y), z) if y + z > x => x + y + z
    } getOrElse 0
  }
}