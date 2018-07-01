import models.JsonFormats._
import models.User
import org.scalatest.BeforeAndAfter
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._
import reactivemongo.bson.BSONDocument
import reactivemongo.play.json.collection.JSONCollection
import reactivemongo.play.json._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class TodoIntegrationSpec extends PlayWithMongoSpec with BeforeAndAfter {

  var users: Future[JSONCollection] = _

  before {
    //Init DB
    await {
      users = reactiveMongoApi.database.map(_.collection("users"))

      users.flatMap(_.insert[User](ordered = false).many(List(
        User(_id = None, title = "Test user 1", completed = Some(false)),
        User(_id = None, title = "Test user 2", completed = Some(true)),
        User(_id = None, title = "Test user 3", completed = Some(false)),
        User(_id = None, title = "Test user 4", completed = Some(true)),
        User(_id = None, title = "Test user 5", completed = Some(true))

      )))
    }
  }

  after {
    //clean DB
    users.flatMap(_.drop(failIfNotFound = false))
  }


  "Get all users" in {
    val Some(result) = route(app, FakeRequest(GET, "/users"))
    val resultList = contentAsJson(result).as[List[User]]
    resultList.length mustEqual 4
    status(result) mustBe OK
  }

  "Add a User" in {
    val payload = User(_id = None, title = "Test newly added User", completed = Some(true))
    val Some(result) = route(app, FakeRequest(POST, "/users").withJsonBody(Json.toJson(payload)))
    status(result) mustBe CREATED
  }

  "Delete a User"  in {
    val query = BSONDocument()
    val Some(userDelete) = await(users.flatMap(_.find(query).one[User]))
    val UserDelete = UserDelete._id.get.stringify
    val Some(result) = route(app, FakeRequest(DELETE, s"/users/$UserDelete"))
    status(result) mustBe OK
  }

  "Update a User" in {
    val query = BSONDocument()
    val payload = Json.obj(
      "id" -> "User updated"
    )

    val Some(userUpdate) = await(users.flatMap(_.find(query).one[User]))
    val userUpdate = userUpdate.id.get.stringify
    val Some(result) = route(app, FakeRequest(PATCH, s"/users/$userUpdate").withJsonBody(payload))
    val updatedUser = contentAsJson(result).as[User]
    updatedUser.title mustEqual "User updated"
    status(result) mustBe OK
  }

}
