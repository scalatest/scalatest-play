import play.api.test._
import play.api.test.Helpers._

class ExampleWithApplicationSpec extends PlaySpec with AppFixture {

  "Application" should {

    "send 404 on a bad request" in {
      route(FakeRequest(GET, "/boum")) shouldBe None
    }

    "render the index page" in {
      val home = route(FakeRequest(GET, "/")).get

      status(home) should equal (OK)
      contentType(home) shouldBe Some("text/html")
      contentAsString(home) should include ("Your new application is ready.")
    }

    "render index template" in {
      val html = views.html.index("ScalaTest 2.0 released!")

      contentType(html) shouldBe ("text/html")
      contentAsString(html) should include ("ScalaTest 2.0")
    }

    "respond to the index Action" in {
      val result = controllers.Application.index()(FakeRequest())

      status(result) should equal (OK)
      contentType(result) shouldBe Some("text/html")
      charset(result) shouldBe Some("utf-8")
      contentAsString(result) should include ("Your new application is ready.")
    }
  }
}
