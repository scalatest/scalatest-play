import org.scalatest._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ExampleUnitSpec extends UnitSpec {

  "Application" should {

    "send 404 on a bad request" in {
      withApplication() {
        route(FakeRequest(GET, "/boum")) shouldBe None
      }
    }

    "render the index page" in new WithApplication{
      withApplication() {
        val home = route(FakeRequest(GET, "/")).get

        status(home) should equal (OK)
        contentType(home) shouldBe Some("text/html")
        contentAsString(home) should include ("Your new application is ready.")
      }
    }

    "render index template" in {
      withApplication() {
        val html = views.html.index("ScalaTest 2.0 released!")

        contentType(html) shouldBe ("text/html")
        contentAsString(html) should include ("ScalaTest 2.0")
      }
    }

    "respond to the index Action" in {
      withApplication() {
        val result = controllers.Application.index()(FakeRequest())

        status(result) should equal (OK)
        contentType(result) shouldBe Some("text/html")
        charset(result) shouldBe Some("utf-8")
        contentAsString(result) should include ("Your new application is ready.")
      }
    }
  }
}
