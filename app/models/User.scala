package models

import javax.inject.Inject

import play.api.libs.json.Json
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.{BSONDocument, BSONObjectID}
import reactivemongo.play.json._
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.{ExecutionContext, Future}




case class User(_id: Option[BSONObjectID], title: String, completed: Option[Boolean])

object JsonFormats{
  import play.api.libs.json._


  implicit val todoFormat: OFormat[User] = Json.format[User]
}

class UsersRepo @Inject()(implicit ec: ExecutionContext, reactiveMongoApi: ReactiveMongoApi){

  import JsonFormats._

  def usersCollection: Future[JSONCollection] = reactiveMongoApi.database.map(_.collection("users"))

  def getAll: Future[Seq[User]] = {
    val query = Json.obj()
    usersCollection.flatMap(_.find(query)
      .cursor[User](ReadPreference.primary)
      .collect[Seq](100, Cursor.FailOnError[Seq[User]]())
    )
  }

  def getUser(id: BSONObjectID): Future[Option[User]] = {
    val query = BSONDocument("_id" -> id)
    usersCollection.flatMap(_.find(query).one[User])
  }


  def addUser(todo: User): Future[WriteResult] = {
    usersCollection.flatMap(_.insert(todo))
  }

  def updateUser(id: BSONObjectID, user: User): Future[Option[User]] = {

    val selector = BSONDocument("_id" -> id)
    val updateModifier = BSONDocument(
      "$set" -> BSONDocument(
        "id" -> user._id,
        "completed" -> user.completed)
    )

    usersCollection.flatMap(
      _.findAndUpdate(selector, updateModifier, fetchNewObject = true).map(_.result[User])
    )
  }

  def deleteUser(id: BSONObjectID): Future[Option[User]] = {
    val selector = BSONDocument("_id" -> id)
    usersCollection.flatMap(_.findAndRemove(selector).map(_.result[User]))
  }

}
