package fixture

import org.scalatest._
import fixture.NoArg
import play.api.test._

abstract class PlaySpec extends fixture.WordSpec with Matchers with OptionValues {

  abstract class App(implicit val app: FakeApplication = FakeApplication()) extends NoArg {
    override def apply() {
      Helpers.running(app)(super.apply())
    }
  }

  abstract class Server(implicit val app: FakeApplication = FakeApplication(), implicit val port: Int = Helpers.testServerPort) extends NoArg {
    override def apply() {
      Helpers.running(TestServer(port, app))(super.apply())
    }
  }
}

