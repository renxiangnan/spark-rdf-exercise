import core.Utils
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import sparkop.op.{BGPUtils, SparkBGP}
import org.apache.jena.graph
import org.apache.jena.graph.{Node, Node_URI}
import org.apache.jena.sparql.core.Var

/**
  * @author xiangnan ren
  */

@RunWith(classOf[JUnitRunner])
class TestJoinKey extends FunSuite with BGPUtils {
  val leftSchema = Array("s", "o")
  val rightSchema = Array("s", "o1")

  assert(f_joinKey(leftSchema, rightSchema).head === "s" )
}

class TestComputeTriplePattern extends FunSuite with BGPUtils {
  val triplePattern: graph.Triple = graph.Triple.
    create(
      Var.alloc("s"),
      Var.alloc("p"),
      Var.alloc("o"))

  val df = Utils.initializeDF("/Users/xiangnanren/Downloads/" +
    "spark-rdf-exercise/src/main/resources/chlorine_7TPE_28.nt")

  assert( df.count === 28)
  assert(computeTriplePattern(triplePattern, df).count() === 28)
}

class TestProjection extends FunSuite {

}


