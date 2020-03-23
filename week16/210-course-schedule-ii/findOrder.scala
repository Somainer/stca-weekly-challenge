object Solution {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val inDegrees = Array.fill(numCourses)(0)
    val edges = Array.fill(numCourses)(collection.mutable.ArrayBuffer.empty[Int])
    prerequisites.foreach { case Array(course, prerequisite) =>
      inDegrees(course) += 1
      edges(prerequisite).addOne(course)
    }
    def topologicalSort: Option[Array[Int]] = {
      val ab = collection.mutable.ArrayBuffer.empty[Int]
      val stk = collection.mutable.Stack.from(inDegrees.indices.filter(inDegrees(_) == 0))
      while (stk.nonEmpty) {
        val top = stk.pop()
        ab += top
        edges(top).foreach { subCourse =>
          inDegrees(subCourse) -= 1
          if (inDegrees(subCourse) == 0) stk.push(subCourse)
        }
      }
      if (ab.lengthIs == numCourses) Some(ab.toArray)
      else None
    }

    topologicalSort.getOrElse(Array.empty)
  }
}