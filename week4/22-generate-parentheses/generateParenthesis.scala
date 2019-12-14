object Solution {
  def generateParenthesis(n: Int, pairs: Int = 0): List[String] = {
    (Seq.fill(n)(-1) ++ Seq.fill(n)(1))
      .permutations
      .filter(_.scan(0)(_ + _).forall(_ <= 0))
      .map(_.map {
        case -1 => '('
        case 1 => ')'
      }.mkString).toList
  }
}