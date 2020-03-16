object Solution {
  def getPermutation(n: Int, k: Int): String = {
    lazy val facts: LazyList[Int] = 1 #:: LazyList.from(1).zip(facts).map(Function.tupled(_ * _))
    def perm(n: Int, k: Int): List[Int] = {
      if (n == 1) List(1)
      else {
        val chunks = facts(n - 1)
        val chunkId = k / chunks
        val idInChunk = k % chunks
        val head = chunkId + 1
        head :: perm(n - 1, idInChunk).map(x => if (x >= head) x + 1 else x)
      }
    }
    perm(n, k - 1).mkString
  }
}