package sparkop.op

import org.apache.jena.graph
import org.apache.jena.sparql.algebra.op.OpBGP
import org.apache.spark.sql.DataFrame
import sparkop.compiler.SparkOpVisitor

/**
  * @author xiangnan ren
  */
class SparkBGP(val opBGP: OpBGP,
               val triples: List[graph.Triple])
  extends SparkOp0 with BGPUtils {

  override def execute(opName: String, inputDF: DataFrame) = {
    ???
  }

  override def visit(sparkOpVisitor: SparkOpVisitor): Unit = {
    sparkOpVisitor.visit(this)
  }
}

object SparkBGP {
  def apply(opBGP: OpBGP,
            triples: List[graph.Triple]): SparkBGP =
    new SparkBGP(opBGP, triples)
}
