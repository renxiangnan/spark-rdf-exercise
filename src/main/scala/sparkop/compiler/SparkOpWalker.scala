package sparkop.compiler
import sparkop.op.{SparkOp, SparkOp0, SparkOp1, SparkOp2}

/**
  * @author xiangnan ren
  */
class SparkOpWalker(val visitor: SparkOpVisitor)
  extends SparkOpVisitorByType {
  def walkBottomUp(op: SparkOp): Unit = {
    op.visit(new SparkOpWalker(visitor))
  }

  override def visit0(op: SparkOp0): Unit = {
    op.visit(visitor)
  }

  override def visit1(op: SparkOp1[SparkOp]): Unit = {
    if (Option(op.subOp).nonEmpty) op.subOp.visit(this)
    op.visit(visitor)
  }

  override def visit2(op: SparkOp2[SparkOp, SparkOp]): Unit = {
    if (Option(op.leftOp).nonEmpty) op.leftOp.visit(this)
    if (Option(op.rightOp).nonEmpty) op.rightOp.visit(this)
    op.visit(visitor)
  }
}

object SparkOpWalker {
  def apply(visitor: SparkOpVisitor): SparkOpWalker =
    new SparkOpWalker(visitor)
}


