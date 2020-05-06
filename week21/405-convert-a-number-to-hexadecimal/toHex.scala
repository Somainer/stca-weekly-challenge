object Solution {
  def toHex(num: Int): String = {
    Iterator.iterate(num)(_ >>> 4).map(_ & 0xf).take(8).map {
      case x if x < 10 => x + '0'
      case x => x - 10 + 'a'
    }.map(_.toChar).mkString.reverse.dropWhile(_ == '0') match {
      case "" => "0"
      case x => x
    }
  }
}