import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{GivenWhenThen, FeatureSpec}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

@RunWith(classOf[JUnitRunner])
class DeployScoversFeatureSpec extends FeatureSpec with ShouldMatchers with GivenWhenThen with MockitoSugar{
  feature("little scover takes first steps") {

    scenario("move forward") {

      given("mission spec - how do i get it to print out the given data :(")
      val spec =
"""
0 0 N
M
"""
      then("result should be .... - how do i not repeat it :(")

      val parser = mock[MissionParser]
      val commander = new ScoverCommander(parser)
      commander.performMission(spec) should equal("0 1 N")
    }

    scenario("turn left"){

      val spec =
"""
0 0 N
L
"""
      val parser = mock[MissionParser]
      val commander = new ScoverCommander(parser)
      commander.performMission(spec) should equal("0 0 W")
      pending
    }

    scenario("turn right") {

      pending

      val spec =
"""
0 0 N
R
"""
      val parser = mock[MissionParser]
      val commander = new ScoverCommander(parser)
      commander.performMission(spec) should equal("0 1 E")
    }


    scenario("practices some ballet"){

      pending

      val spec =
"""
0 0 E
MLM
"""
      val parser = mock[MissionParser]
      val commander = new ScoverCommander(parser)
      commander.performMission(spec) should equal ("1 1 N")

    }
  }
}

