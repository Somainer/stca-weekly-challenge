object Solution {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    val analyse = collection.mutable.Map.empty[Int, Int]
    nums.foreach { i =>
      analyse.update(i, analyse.getOrElse(i, 0) + 1)
    }
    analyse.foldLeft(List(List.empty[Int])) { case (ls, (key, num)) =>
        0.until(num).toList.scanLeft(List.empty[Int]){ case (l, _) => key :: l }
          .flatMap(xs => ls.map(xs ::: _))
    }
  }
}