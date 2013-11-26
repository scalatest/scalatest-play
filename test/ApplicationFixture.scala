
import org.scalatest._
import play.api.test._
import LoanFixtureMethods._

trait ApplicationFixture extends SuiteMixin { this: Suite =>

  protected def playApp = new FakeApplication()

  abstract override def withFixture(test: NoArgTest) =
    withApplication(playApp) {
      super.withFixture(test)
    }
}
