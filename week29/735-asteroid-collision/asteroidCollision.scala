object Solution {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    val stack = collection.mutable.Stack.empty[Int]
    asteroids.foreach { i =>
      var alive = true
      if (i < 0) stack.popWhile { x =>
        x > 0 && alive && {
          if (i.abs <= x.abs) alive = false
          x.abs <= i.abs
        }
      }
      if (alive) stack.push(i)
    }
    stack.toArray.reverse
  }
}