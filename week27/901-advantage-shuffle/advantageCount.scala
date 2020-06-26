object Solution {
  def advantageCount(A: Array[Int], B: Array[Int]): Array[Int] = {
    val aBuff = A.sortInPlace().toBuffer
    B.map { b =>
      aBuff.indexWhere(_ > b) match {
        case -1 => 
          aBuff.remove(0)
        case i => aBuff.remove(i)
      }
    }
  }
}