object Solution {
  def simplifyPath(path: String): String = {
    @scala.annotation.tailrec
    def simplify(paths: List[String], route: List[String]): String = {
      if (paths.isEmpty) route.reverseIterator.mkString("/", "/", "")
      else {
        val tail = paths.tail
        paths.head match {
          case "" | "." => simplify(tail, route)
          case ".." => route match {
            case _ :: t => simplify(tail, t)
            case t => simplify(tail, t)
          }
          case p => simplify(tail, p :: route)
        }
      }
    }
    simplify(path.split("/").toList, Nil)
  }
}