package example

import unfiltered.filter.Plan
import unfiltered.request._
import unfiltered.response._

object Hello extends Greeting with App {
  startServer
}

trait Greeting {
  def startServer: Unit = {
    val echo: Plan = unfiltered.filter.Planify {
      case Path(Seg(p :: Nil)) => ResponseString(p)
    }

    unfiltered.jetty.Server.anylocal.plan(echo).run()
  }
}
