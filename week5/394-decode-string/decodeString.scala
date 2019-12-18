object Solution {
  def decodeString(s: String): String = {
    s.indexWhere(_.isDigit) match {
      case -1 => s
      case ix =>
        val (prefix, toUnpack) = s.splitAt(ix)
        val recursiveFrom = toUnpack.indexOf('[')
        val stackView = toUnpack.substring(recursiveFrom)
        val recursiveTo = toUnpack.substring(recursiveFrom).map {
          case '[' => 1
          case ']' => -1
          case _ => 0
        }.scanLeft(0)(_ + _).tail.indexOf(0) + recursiveFrom
        val repeatNum = toUnpack.substring(0, recursiveFrom).toInt
        val toRepeat = toUnpack.substring(recursiveFrom + 1, recursiveTo)
        val decoded = decodeString(toRepeat)
        val rest = toUnpack.substring(recursiveTo + 1)
        s"$prefix${decoded * repeatNum}${decodeString(rest)}"
    }
  }
}