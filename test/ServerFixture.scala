
import org.scalatest._
import play.api.test._

trait ServerFixture extends SuiteMixin { this: Suite =>

  implicit val app: FakeApplication = new FakeApplication()
  implicit val port: Int = Helpers.testServerPort

  abstract override def withFixture(test: NoArgTest) =
    Helpers.running(TestServer(port, app)) {
      super.withFixture(test)
    }
}

