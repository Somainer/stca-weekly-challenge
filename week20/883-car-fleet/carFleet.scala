object Solution {
  def carFleet(target: Int, position: Array[Int], speed: Array[Int]): Int = {
    position.zip(speed).sortBy(-_._1).map { case (pos, spd) =>
      1.0 * (target - pos) / spd
    }.foldLeft((0, Double.MinValue)) {
      case ((count, lastTime), time) =>
        if (time > lastTime) (count + 1, time)
        else (count, lastTime)
    }._1
  }
}