import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{GivenWhenThen, FeatureSpec}



@RunWith(classOf[JUnitRunner])
class DeployScoversFeatureSpec extends FeatureSpec with ShouldMatchers with GivenWhenThen{
  feature("little scover takes first steps") {

    scenario("move forward") {

      given("mission spec - how do i get it to print out the given data :(")
      val spec =
"""
0 0 N
M
"""
      then("result should be .... - how do i not repeat it :(")

      val commander = new ScoverCommander
      commander.performMission(spec) should equal("0 1 N")
    }

    scenario("turn left"){

      val spec =
"""
0 0 N
L
"""
      val commander = new ScoverCommander
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
      val commander = new ScoverCommander
      commander.performMission(spec) should equal("0 1 E")
    }


    scenario("practices some ballet"){

      pending

      val spec =
"""
0 0 E
MLM
"""
      val commander = new ScoverCommander
      commander.performMission(spec) should equal ("1 1 N")

    }


  }
}

