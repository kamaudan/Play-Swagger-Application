
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dan/play26-swagger-reactivemongo/conf/routes
// @DATE:Fri Jun 29 18:09:45 EAT 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseApiHelpController ApiHelpController = new controllers.ReverseApiHelpController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserApi UserApi = new controllers.ReverseUserApi(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApiDocsController ApiDocsController = new controllers.ReverseApiDocsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseApiHelpController ApiHelpController = new controllers.javascript.ReverseApiHelpController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserApi UserApi = new controllers.javascript.ReverseUserApi(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApiDocsController ApiDocsController = new controllers.javascript.ReverseApiDocsController(RoutesPrefix.byNamePrefix());
  }

}
