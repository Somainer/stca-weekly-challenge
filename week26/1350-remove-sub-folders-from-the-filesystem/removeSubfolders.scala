object Solution {
  def removeSubfolders(folder: Array[String]): List[String] = {
    folder.sorted.map(_.split('/').toList).foldLeft(Set.empty[List[String]]) {
      case (folders, f) =>
        if (folders.exists(f.startsWith(_))) folders
        else folders incl f
    }.map(_ mkString "/").toList
  }
}