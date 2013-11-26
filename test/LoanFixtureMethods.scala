import play.api.test._
import org.openqa.selenium.WebDriver

/**
 * Trait to support ScalaTest usage in Play Framework.
 */
trait LoanFixtureMethods {

  def withApplication[T](app: FakeApplication = new FakeApplication())(block: => T): T = {
    Helpers.running(app) {
      block
    }
  }

  def withServer[T](app: FakeApplication = new FakeApplication(), port: Int = Helpers.testServerPort)(block: Int => T): T = {
    Helpers.running(TestServer(port, app)) {
      block(port)
    }
  }

  def withBrowser[T](app: FakeApplication = new FakeApplication(),
                     port: Int = Helpers.testServerPort)(block: Int => T)(implicit webDriver: WebDriver): T = {
    try {
      Helpers.running(TestServer(port, app)) {
        block(port)
      }
    } finally {
      webDriver.quit()
    }
  }

}

object LoanFixtureMethods extends LoanFixtureMethods

