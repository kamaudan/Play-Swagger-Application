
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dan/play26-swagger-reactivemongo/conf/routes
// @DATE:Fri Jun 29 18:09:45 EAT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.modules.reactivemongo.PathBindables._

// @LINE:5
package controllers {

  // @LINE:16
  class ReverseApiHelpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getResources(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "swagger.json")
    }
  
  }

  // @LINE:5
  class ReverseUserApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def getUser(id:reactivemongo.bson.BSONObjectID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectID]].unbind("id", id)))
    }
  
    // @LINE:12
    def deleteUser(id:reactivemongo.bson.BSONObjectID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectID]].unbind("id", id)))
    }
  
    // @LINE:10
    def updateUser(id:reactivemongo.bson.BSONObjectID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[reactivemongo.bson.BSONObjectID]].unbind("id", id)))
    }
  
    // @LINE:5
    def getAllUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:8
    def addNewUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
  }

  // @LINE:20
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:15
  class ReverseApiDocsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def redirectToDocs(): Call = {
    
      () match {
      
        // @LINE:15
        case ()  =>
          
          Call("GET", _prefix)
      
      }
    
    }
  
  }


}
