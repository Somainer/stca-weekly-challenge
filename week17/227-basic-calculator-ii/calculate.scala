object Solution {
  def calculate(s: String): Int = {
    import util.control.Breaks._
    val it = s.iterator.filterNot(_.isWhitespace).buffered
    def nextNumber = {
      var r = 0
      while (it.hasNext && it.head.isDigit) {
        r = r * 10 + (it.next() - '0')
      }
      r
    }
    def nextFactor: Int = {
      var number = nextNumber
      breakable {
        while (it.hasNext) {
          it.head match {
            case '*' => it.next(); number *= nextNumber
            case '/' => it.next(); number /= nextNumber
            case _ => break()
          }
        }
      }
      number
    }
    def nextExpression: Int = {
      var number = nextFactor
      breakable {
        while (it.hasNext) {
          it.head match {
            case '+' => it.next(); number += nextFactor
            case '-' => it.next(); number -= nextFactor
            case _ => break()
          }
        }
      }
      number
    }
    nextExpression
  }
}