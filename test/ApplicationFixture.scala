import play.api.test._

abstract class WithApplicationSpec extends UnitSpec {

  protected def playApp = new FakeApplication()

  override def withFixture(test: NoArgTest) =
    withApplication(playApp) {
      super.withFixture(test)
    }
}
