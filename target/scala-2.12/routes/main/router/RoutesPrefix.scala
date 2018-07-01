
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dan/play26-swagger-reactivemongo/conf/routes
// @DATE:Fri Jun 29 18:09:45 EAT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
