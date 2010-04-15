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

      Befehl.turnLeft(Position(4,5,"W")) should be ( Position(4,5,"S")  )
      Befehl.turnRight(Position(2,1,"W")) should be ( Position(2,1,"N")  )
      Befehl.move(Position(2,1,"W")) should be ( Position(1,1,"W")  )
      Befehl.move(Position(2,-1,"N")) should be ( Position(2,0,"N")  )
    }

    it("should apply functions from the command strings"){

      val scover = Scover(0,0,"N",List("M", "L", "M"))

      FunctionThrowingMission(Plateau(5,5), scover).run should be (Position(-1,1,"W")) 

    }

    it("should give starting position when no commands"){

      val scover = Scover(654,232,"E",Nil)

      FunctionThrowingMission(Plateau(5,5), scover).run should be (Position(scover.x, scover.y, scover.direction))

    }


  }



}