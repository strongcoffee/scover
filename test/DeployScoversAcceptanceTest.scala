
class DeployScoversAcceptanceTest extends org.scalatest.Suite {

  def testLittleScoverTakesFirstStep() {

    val missionSpec =
"""
5 5
0 0 N
M
"""
    val expectedReport = "0 1 N"

    assert( scoverCommander.performMission(missionSpec) == expectedReport )
  }
}


(new DeployScoversAcceptanceTest).execute()
