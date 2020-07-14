object Solution {
  def buildArray(target: Array[Int], n: Int): List[String] = {
    val targetList = target.toList
    val pushPop = List("Push", "Pop")
    targetList.prepended(0).zip(targetList).flatMap { case (last, current) =>
      0.until(current - last).flatMap(_ => pushPop).init
    }
  }
}