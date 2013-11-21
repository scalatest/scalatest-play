import org.scalatest._
import selenium._

import play.api.test._
import play.api.test.Helpers._

class SeleniumDslIntegrationSpec extends WordSpec with Matchers with HtmlUnit {

  "Application" should {

    "work from within a browser" in running(TestServer(testServerPort)) {

      go to ("http://localhost:" + testServerPort)

      pageSource should include ("Your new application is ready.")
    }
  }

}
