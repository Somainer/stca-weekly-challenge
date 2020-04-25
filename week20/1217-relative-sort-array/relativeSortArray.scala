object Solution {
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    arr1.sortBy(x => arr2.indexOf(x) match {
      case -1 => arr2.length + x
      case x => x
    })
  }
}