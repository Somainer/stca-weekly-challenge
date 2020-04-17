/*
// Employee info
class Employee() {
    // It's the unique id of each node;
    // unique id of this employee
    var id: Int = 0
    // the importance value of this employee
    var importance: Int = 0
    // the id of direct subordinates
    var subordinates: List[Int] = List()
};
*/

object Solution {
  def getImportance(employees: List[Employee], id: Int): Int = {
    val employeeMap = employees.map(e => e.id -> e).toMap
    def importance(employee: Employee): Int = {
      employee.subordinates.view.map(employeeMap).map(importance).sum + employee.importance
    }
    importance(employeeMap(id))
  }
}