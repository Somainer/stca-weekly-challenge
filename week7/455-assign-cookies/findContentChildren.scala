object Solution {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    val gs = g.sorted
    val ss = s.sorted
    var gi = 0
    var si = 0
    while (gi < g.length && si < s.length) {
      if (ss(si) >= gs(gi)) gi += 1
      si += 1
    }
    gi
  }
}