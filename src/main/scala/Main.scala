import io.circe.Json
import profile.{ProfileRepo, ProfileSchema}
import sangria.execution.Executor
import sangria.macros._
import sangria.marshalling.circe._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}


object Main extends App {
  val query =
    graphql"""
    query MyProfile {
      profile(id: "2") {
        name
        age
        address {
          postCode, lines
        }
      }
      profiles {
        name
      }
    }
  """

  val result: Future[Json] =
    Executor.execute(ProfileSchema.schema, query, new ProfileRepo)

  result.onComplete({
    case Success(value) => {
      println("done")
      println(value)
    }
    case Failure(exception) => {
      println("error")
      println(exception)
    }
  })

  Thread.sleep(1000)
}
