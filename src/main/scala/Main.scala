import unfiltered.filter.Plan
import unfiltered.request._
import unfiltered.response._

object Main extends Main with App {
  start
}

class Main {
  val echo: Plan = unfiltered.filter.Planify {
    case Path(Seg(p :: Nil)) => ResponseString(p)
  }

  def start = {
    unfiltered.jetty.Server.http(8080).plan(echo).run()
  }
}
