package sparkop.op

import org.apache.jena.sparql.algebra.op.OpProject
import org.apache.spark.sql.DataFrame
import sparkop.compiler.SparkOpVisitor

/**
  * @author xiangnan ren
  */
class SparkProjection(val opProject: OpProject,
                      subOp: SparkOp) extends
  SparkOpModifier(subOp: SparkOp) {
  def execute(opName: String,
              child: DataFrame): DataFrame = {
    ???
  }

  override def visit(sparkOpVisitor: SparkOpVisitor): Unit = {
    sparkOpVisitor.visit(this)
  }

}

object SparkProjection {
  def apply(opProject: OpProject,
            subOp: SparkOp): SparkProjection =
    new SparkProjection(opProject, subOp)
}