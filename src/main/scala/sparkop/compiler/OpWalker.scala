package sparkop.compiler

import org.apache.jena.sparql.algebra.op._
import org.apache.jena.sparql.algebra.{Op, OpVisitor, OpVisitorByType}

/**
  * @author xiangnan ren
  */
class OpWalker (val visitor: OpVisitor)
  extends OpVisitorByType {
  def walkBottomUp(op: Op): Unit = {
    op.visit(this)
  }

  override def visit0(op: Op0): Unit = {
    op.visit(visitor)
  }

  override def visit1(op: Op1): Unit = {
    if (Option(op.getSubOp).nonEmpty)
      op.getSubOp.visit(this)
    op.visit(visitor)
  }

  // Following methods are not required for the moment...
  override def visitFilter(op: OpFilter): Unit = {}
  override def visitLeftJoin(op: OpLeftJoin): Unit = {}
  override def visitExt(op: OpExt): Unit = {}
  override def visit2(op: Op2): Unit = {}
  override def visitN(op: OpN): Unit = {}
}

object OpWalker {
  def apply(visitor: OpVisitor): OpWalker =
    new OpWalker(visitor)
}