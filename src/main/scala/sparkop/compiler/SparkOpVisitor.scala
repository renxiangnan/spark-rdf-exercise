package sparkop.compiler

import sparkop.op.{SparkBGP, SparkProjection}

/**
  * @author xiangnan ren
  */
trait SparkOpVisitor {
  def visit(sparkProject: SparkProjection): Unit
  def visit(sparkBGP: SparkBGP): Unit
}
