
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dan/play26-swagger-reactivemongo/conf/routes
// @DATE:Fri Jun 29 18:09:45 EAT 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.modules.reactivemongo.PathBindables._

// @LINE:5
package controllers.javascript {

  // @LINE:16
  class ReverseApiHelpController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getResources: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiHelpController.getResources",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "swagger.json"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseUserApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserApi.getUser",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectID]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserApi.deleteUser",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectID]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:10
    def updateUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserApi.updateUser",
      """
        function(id0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectID]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:5
    def getAllUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserApi.getAllUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:8
    def addNewUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserApi.addNewUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseApiDocsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def redirectToDocs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiDocsController.redirectToDocs",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + """"})
          }
        
        }
      """
    )
  
  }


}
