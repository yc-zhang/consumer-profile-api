import unfiltered.filter.Plan
import unfiltered.request._
import unfiltered.response._

object Main extends Main with App {
  start()
}

class Main {
  val port = 8080

  val echo: Plan = unfiltered.filter.Planify {
    case Path(Seg(p :: Nil)) => ResponseString(p)
  }

  def start(): Unit = {
    unfiltered.jetty.Server.http(port).plan(echo).run()
  }
}
