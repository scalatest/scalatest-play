import org.scalatest._
import play.api.test._

abstract class WithServerSpec extends fixture.WordSpec
                              with Matchers
                              with OptionValues
                              with ScalaTestSupport {

  protected def playApp = new FakeApplication()

  type FixtureParam = Int

  override def withFixture(test: OneArgTest) =
    withServer(playApp) { port =>
      super.withFixture(test.toNoArgTest(port))
    }
}