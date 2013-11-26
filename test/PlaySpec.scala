import org.scalatest._

abstract class PlaySpec extends WordSpec
                        with OneInstancePerTest
                        with Matchers
                        with OptionValues
