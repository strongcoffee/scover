import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec


@RunWith(classOf[JUnitRunner])
class FunctionThrowingMissionSpec extends Spec with ShouldMatchers {

  describe("Direction") {

    it("should get clockwise point") {

      Direction.clockwise("E") should be("S")
      Direction.clockwise("N") should be("E")


    }

    it("should get anticlockwise point") {

      Direction.anticlockwise("S") should be("E")
      Direction.anticlockwise("E") should be("N")

    }

  }

  describe("Commands"){

    it("should do as i command, just like everything else in the universe") {

      Befehl.turnLeft (4,5,"W") should be ( (4,5,"S")  )
      Befehl.turnRight (2,1,"W") should be ( (2,1,"N")  )
      Befehl.move (2,1,"W") should be ( (1,1,"W")  )
      Befehl.move (2,-1,"N") should be ( (2,0,"N")  )
    }

    
  }

}