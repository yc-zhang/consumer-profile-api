import javax.servlet.http.HttpServletRequest
import unfiltered.filter.Plan
import unfiltered.request.{HttpRequest, _}
import unfiltered.response._

object Main extends Main with App {
  start()
}

class Main {
  val port = 8080

  type Request = HttpRequest[HttpServletRequest]

  val echo: Plan = unfiltered.filter.Planify {
    case GET(Path("/helloworld")) => Ok ~> ResponseString("hello world")
    case req @ GET(Path("/helloworld_2")) => process(helloWorld2)(req)
  }

  def process[A, B](business: A => BusinessResult[B])(req: Request)
                   (implicit parse: Request => A, toR: B => String):
  ResponseFunction[Any] = {
    val result: BusinessResult[B] = business.apply(parse(req))
    result.status ~> ResponseString(toR(result.result))
  }

  def start(): Unit = {
    unfiltered.jetty.Server.http(port).plan(echo).run()
  }

  def helloWorld2(name: String): BusinessResult[String] = {
    BusinessResult(Ok, s"$name, hello and welcome!")
  }

  implicit def toHello(request: Request): String = {
    request.parameterValues("name").head
  }
}


case class BusinessResult[A](status: Status, result: A)
