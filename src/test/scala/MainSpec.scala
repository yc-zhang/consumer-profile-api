import org.specs2._
import unfiltered.jetty.Server

object MainSpec extends Specification with unfiltered.specs2.jetty.Served {

  override def setup: Server => Server = {
    _.plan(Main.echo)
  }

  "The example app" should {
    "should echo any request" in {
      val response = httpx(req(host / "test"))

      response.code must_== 200
      response.as_string must contain("test")
    }
  }
}
