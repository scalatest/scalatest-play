import org.scalatest._
import selenium.HtmlUnit
import play.api.test._

abstract class WithBrowserSpec extends fixture.WordSpec
                                   with Matchers
                                   with OptionValues
                                   with HtmlUnit
                                   with ScalaTestSupport {

  protected def playApp = new FakeApplication()

  type FixtureParam = Int

  override def withFixture(test: OneArgTest) =
    withBrowser(playApp) { port =>
      super.withFixture(test.toNoArgTest(port))
    }
}