/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
class ExampleIntegrationSpec extends IntegrationSpec {

  "Application" should {

    "work from within a browser" in {
      withBrowser() { port =>
        go to ("http://localhost:" + port)
        pageSource should include ("Your new application is ready.")
      }
    }
  }
}