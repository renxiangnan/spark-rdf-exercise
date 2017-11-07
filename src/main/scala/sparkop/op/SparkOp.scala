package sparkop.op

import sparkop.compiler.SparkOpVisitor

/**
  * @author xiangnan ren
  */
trait SparkOp {
  def visit(sparkOpVisitor: SparkOpVisitor): Unit
}
