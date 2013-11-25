class ExampleWithBrowserSpec extends WithBrowserSpec {

  "Application" should {

    "work from within a browser" in { port =>
      go to ("http://localhost:" + port)
      pageSource should include ("Your new application is ready.")
    }
  }

}