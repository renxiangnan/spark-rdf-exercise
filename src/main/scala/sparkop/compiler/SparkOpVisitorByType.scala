package sparkop.compiler

import sparkop.op._

/**
  * @author xiangnan ren
  */
abstract class SparkOpVisitorByType extends SparkOpVisitor {
  /**
    * Define basic visit methods as final,
    * the override is not permitted.
    */
  override final def visit(sparkBGP: SparkBGP): Unit = {
    visit0(sparkBGP)
  }

  override final def visit(sparkProject: SparkProjection): Unit = {
    visit1(sparkProject)
  }

  def visit0(op: SparkOp0)

  def visit1(op: SparkOp1[SparkOp])

  def visit2(op: SparkOp2[SparkOp, SparkOp])
}
