
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dan/play26-swagger-reactivemongo/conf/routes
// @DATE:Fri Jun 29 18:09:45 EAT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.modules.reactivemongo.PathBindables._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  UserApi_3: controllers.UserApi,
  // @LINE:15
  ApiDocsController_1: controllers.ApiDocsController,
  // @LINE:16
  ApiHelpController_2: controllers.ApiHelpController,
  // @LINE:20
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    UserApi_3: controllers.UserApi,
    // @LINE:15
    ApiDocsController_1: controllers.ApiDocsController,
    // @LINE:16
    ApiHelpController_2: controllers.ApiHelpController,
    // @LINE:20
    Assets_0: controllers.Assets
  ) = this(errorHandler, UserApi_3, ApiDocsController_1, ApiHelpController_2, Assets_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserApi_3, ApiDocsController_1, ApiHelpController_2, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserApi.getAllUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserApi.getUser(id:reactivemongo.bson.BSONObjectID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.UserApi.addNewUser"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserApi.updateUser(id:reactivemongo.bson.BSONObjectID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserApi.deleteUser(id:reactivemongo.bson.BSONObjectID)"""),
    ("""GET""", this.prefix, """controllers.ApiDocsController.redirectToDocs"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """swagger.json""", """controllers.ApiHelpController.getResources"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-docs""", """controllers.ApiDocsController.redirectToDocs"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_UserApi_getAllUsers0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserApi_getAllUsers0_invoker = createInvoker(
    UserApi_3.getAllUsers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserApi",
      "getAllUsers",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_UserApi_getUser1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserApi_getUser1_invoker = createInvoker(
    UserApi_3.getUser(fakeValue[reactivemongo.bson.BSONObjectID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserApi",
      "getUser",
      Seq(classOf[reactivemongo.bson.BSONObjectID]),
      "GET",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserApi_addNewUser2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UserApi_addNewUser2_invoker = createInvoker(
    UserApi_3.addNewUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserApi",
      "addNewUser",
      Nil,
      "POST",
      this.prefix + """user""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserApi_updateUser3_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserApi_updateUser3_invoker = createInvoker(
    UserApi_3.updateUser(fakeValue[reactivemongo.bson.BSONObjectID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserApi",
      "updateUser",
      Seq(classOf[reactivemongo.bson.BSONObjectID]),
      "PATCH",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserApi_deleteUser4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserApi_deleteUser4_invoker = createInvoker(
    UserApi_3.deleteUser(fakeValue[reactivemongo.bson.BSONObjectID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserApi",
      "deleteUser",
      Seq(classOf[reactivemongo.bson.BSONObjectID]),
      "DELETE",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ApiDocsController_redirectToDocs5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ApiDocsController_redirectToDocs5_invoker = createInvoker(
    ApiDocsController_1.redirectToDocs,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiDocsController",
      "redirectToDocs",
      Nil,
      "GET",
      this.prefix + """""",
      """ Swagger docs""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ApiHelpController_getResources6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("swagger.json")))
  )
  private[this] lazy val controllers_ApiHelpController_getResources6_invoker = createInvoker(
    ApiHelpController_2.getResources,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResources",
      Nil,
      "GET",
      this.prefix + """swagger.json""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ApiDocsController_redirectToDocs7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs")))
  )
  private[this] lazy val controllers_ApiDocsController_redirectToDocs7_invoker = createInvoker(
    ApiDocsController_1.redirectToDocs,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiDocsController",
      "redirectToDocs",
      Nil,
      "GET",
      this.prefix + """api-docs""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_UserApi_getAllUsers0_route(params@_) =>
      call { 
        controllers_UserApi_getAllUsers0_invoker.call(UserApi_3.getAllUsers)
      }
  
    // @LINE:6
    case controllers_UserApi_getUser1_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectID]("id", None)) { (id) =>
        controllers_UserApi_getUser1_invoker.call(UserApi_3.getUser(id))
      }
  
    // @LINE:8
    case controllers_UserApi_addNewUser2_route(params@_) =>
      call { 
        controllers_UserApi_addNewUser2_invoker.call(UserApi_3.addNewUser)
      }
  
    // @LINE:10
    case controllers_UserApi_updateUser3_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectID]("id", None)) { (id) =>
        controllers_UserApi_updateUser3_invoker.call(UserApi_3.updateUser(id))
      }
  
    // @LINE:12
    case controllers_UserApi_deleteUser4_route(params@_) =>
      call(params.fromPath[reactivemongo.bson.BSONObjectID]("id", None)) { (id) =>
        controllers_UserApi_deleteUser4_invoker.call(UserApi_3.deleteUser(id))
      }
  
    // @LINE:15
    case controllers_ApiDocsController_redirectToDocs5_route(params@_) =>
      call { 
        controllers_ApiDocsController_redirectToDocs5_invoker.call(ApiDocsController_1.redirectToDocs)
      }
  
    // @LINE:16
    case controllers_ApiHelpController_getResources6_route(params@_) =>
      call { 
        controllers_ApiHelpController_getResources6_invoker.call(ApiHelpController_2.getResources)
      }
  
    // @LINE:17
    case controllers_ApiDocsController_redirectToDocs7_route(params@_) =>
      call { 
        controllers_ApiDocsController_redirectToDocs7_invoker.call(ApiDocsController_1.redirectToDocs)
      }
  
    // @LINE:20
    case controllers_Assets_versioned8_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
