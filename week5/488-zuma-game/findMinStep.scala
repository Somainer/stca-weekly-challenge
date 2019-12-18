object Solution {
  def findMinStep(board: String, hand: String): Int = {
    globalMinStep = Int.MaxValue
    hasAns = false
    dfs(board, hand, 0)
    if(hasAns) globalMinStep else -1
  }
  private var globalMinStep = Int.MaxValue
  private var hasAns = false
  def dfs(board: String, hand: String, step: Int): Unit = {
    if(board.isEmpty) {
      globalMinStep = globalMinStep min step
      hasAns = true
      return
    }
    if (step + 1 >= globalMinStep) return
    val usefulHand = hand.filter(board.contains(_))
    val played = collection.mutable.Set.empty[Char]
    usefulHand.indices.foreach { toPlayIndex =>
      val toPlay = usefulHand.charAt(toPlayIndex)
      val newHand = usefulHand.substring(0, toPlayIndex) + usefulHand.substring(toPlayIndex + 1)
      if(!played.contains(toPlay)) {
        played.add(toPlay)
        board.indices.foreach { i =>
          if (i == 0 || (board.charAt(i) != board.charAt(i - 1))) {
            if (board.charAt(i) == toPlay) {
              val newBoard = board.substring(0, i) + toPlay + board.substring(i)
              dfs(removeDuplicates(newBoard), newHand, step + 1)
            }
          }
        }
      }
    }
  }

  @annotation.tailrec
  def removeDuplicates(s: String): String = {
    val sb = new StringBuilder
    var lastC: Char = 0
    var continueCount = 0
    s.concat("#").foreach {c =>
      if (lastC == c) continueCount += 1
      else {
        if (continueCount < 3 && continueCount > 0) {
          1 to continueCount foreach { _ => sb.append(lastC) }
        }
        continueCount = 1
        lastC = c
      }
    }
    val result = sb.result()
    if (result == s) result
    else removeDuplicates(result)
  }
}