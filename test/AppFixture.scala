
import org.scalatest._
import play.api.test._

trait AppFixture extends SuiteMixin { this: Suite =>

  val app = new FakeApplication()

  abstract override def withFixture(test: NoArgTest) =
    Helpers.running(app) {
      super.withFixture(test)
    }
}

