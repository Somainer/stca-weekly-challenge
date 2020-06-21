object Solution {
  def validIPAddress(IP: String): String = {
    val ipv4Groups = IP.split("\\.", -1)
    if (ipv4Groups.length == 4 && ipv4Groups.forall { unit =>
      unit.toIntOption.filter(_.toString == unit).exists((0 until 256).contains)
    }) "IPv4"
    else {
      val ipv6Groups = IP.split(":", -1)
      if (ipv6Groups.length == 8 && ipv6Groups.forall { unit =>
        unit.length <= 4 && !unit.startsWith("-") && 
          scala.util.Try(Integer.parseInt(unit, 16)).filter(_ >= 0).isSuccess
      }) "IPv6"
      else "Neither"
    }
  }
}