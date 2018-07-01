package controllers

import javax.inject.Inject

import io.swagger.annotations._
import models.JsonFormats._
import models.{User, UsersRepo}
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import reactivemongo.bson.BSONObjectID

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future



@Api(value = "/users")
class UserApi @Inject()(cc: ControllerComponents, userRepo: UsersRepo) extends AbstractController(cc) {

  @ApiOperation(
    value = "Find all User",
    response = classOf[User],

    responseContainer = "List"
  )

  def getAllUsers = Action.async {
    userRepo.getAll.map { User =>
      Ok(Json.toJson(User))
    }
  }.





  @ApiOperation(
    value = "Get a user",
    response = classOf[User],

    responseContainer ="List"

  )

  @ApiResponses(Array(
      new ApiResponse(code = 404, message = "User not found")
    )
  )



  def getUser(@ApiParam(value = "The id of the user to get") userId: BSONObjectID) = Action.async{ req =>
    userRepo.getUser(userId).map{ maybeUser =>
      maybeUser.map{ user: User =>
        Ok(Json.toJson(user))
      }.getOrElse(NotFound)
    }
  }

  @ApiOperation(
    value = "Add a new user to the list",
    response = classOf[Void],
    code = 201
  )
  @ApiResponses(Array(
      new ApiResponse(code = 400, message = "Invalid User format")
    )
  )
  @ApiImplicitParams(Array(
      new ApiImplicitParam(value = "The User to add, in Json Format", required = true, dataType = "models.User", paramType = "body")
    )
  )
  def addNewUser() = Action.async(parse.json){ req =>
    req.body.validate[User].map{ user: User =>
      userRepo.addUser(user).map{ _ =>
        Created

      }
    }.getOrElse(Future.successful(BadRequest("Invalid User format")))
  }

  @ApiOperation(
    value = "Update a User",
    response = classOf[User]
  )
  @ApiResponses(Array(
      new ApiResponse(code = 400, message = "Invalid User format")
    )
  )
  @ApiImplicitParams(Array(
      new ApiImplicitParam(value = "The updated User, in Json Format", required = true, dataType = "models.User", paramType = "body")
    )
  )
  def updateUser(@ApiParam(value = " Will user this id to update the User")
                 todoId: BSONObjectID) = Action.async(parse.json){ req =>
    req.body.validate[User].map{ user: User =>
      userRepo.updateUser(todoId, user).map {
        case Some(user) => Ok(Json.toJson(user))
        case None => NotFound
      }
    }.getOrElse(Future.successful(BadRequest("Invalid Json")))
  }

  @ApiOperation(
    value = "Delete a user",
    response = classOf[User]
  )
  def deleteUser(@ApiParam(value = "The id of the user to delete") todoId: BSONObjectID) = Action.async{ req =>
    userRepo.deleteUser(todoId).map {
      case Some(todo) => Ok(Json.toJson(todo))
      case None => NotFound
    }
  }

}
