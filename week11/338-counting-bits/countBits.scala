/** It works perfectly on my machine but not on leetcode. But I believe it is right.
* So here is another C++ solution.
*/
object Solution {
  def countBits(num: Int): Array[Int] = {
    val result = collection.mutable.Seq.fill(num + 1)(0)
    1.to(num).foreach { i =>
      result.update(i, result(i & (i - 1)) + 1)
    }
    result.toArray
  }
}