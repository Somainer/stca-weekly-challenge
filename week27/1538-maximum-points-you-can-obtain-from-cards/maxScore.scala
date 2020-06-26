object Solution {
  def maxScore(cardPoints: Array[Int], k: Int): Int = {
    val toDrop = cardPoints.length - k
    cardPoints.sum - cardPoints.indices.take(k).scanLeft(cardPoints.take(toDrop).sum) {
      case (sum, i) => sum - cardPoints(i) + cardPoints(i + toDrop)
    }.min
  }
}