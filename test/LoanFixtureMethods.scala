import play.api.test._
import org.openqa.selenium.WebDriver

/**
 * Trait to support ScalaTest usage in Play Framework.
 */
trait LoanFixtureMethods {

  def withApp(app: FakeApplication = new FakeApplication())(block: => Unit): Unit = {
    Helpers.running(app) {
      block
    }
  }

  def app(block: => Unit): Unit = {
    Helpers.running(new FakeApplication()) {
      block
    }
  }

  def appUsing(app: FakeApplication)(block: => Unit): Unit = {
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

