object Solution {
  def minimumDistance(word: String): Int = {
    val letterCodes = 0 until 26
    val poses = letterCodes.map { c =>
      (c, (c / 6, c % 6))
    }.toMap
    def distOf(a: Int, b: Int): Int = {
      val (ax, ay) = poses(a)
      val (bx, by) = poses(b)
      (ax - bx).abs + (ay - by).abs
    }

    val cache = Array.fill(36, 36, word.length)(-1)
    val codePrints = word.map(_ - 'A')

    def dfs(posA: Int, posB: Int, wordPoint: Int): Int = {
      if (wordPoint >= word.length) 0
      else {
        val mem = cache(posA)(posB)(wordPoint)
        if (mem >= 0) mem
        else {
          val head = codePrints(wordPoint)
          val moveA = dfs(head, posB, wordPoint + 1) + distOf(posA, head)
          val moveB = dfs(posA, head, wordPoint + 1) + distOf(posB, head)
          val result = moveA min moveB
          cache(posA)(posB)(wordPoint) = result
          result
        }
      }
    }

    codePrints.flatMap { posA =>
      codePrints.map(dfs(posA, _, 0))
    }.min
  }
}