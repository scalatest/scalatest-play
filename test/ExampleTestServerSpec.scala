import play.api.libs.ws.WS
import play.api.test.Helpers._

class ExampleTestServerSpec extends IntegrationSpec {

  "Application" should {

    "work from within a browser" in {
      withServer() { port =>
        // await is from play.api.test.FutureAwaits
        val response = await(WS.url("http://localhost:" + port + "/boum").get())
        response.status shouldBe 404
      }
    }
  }
}