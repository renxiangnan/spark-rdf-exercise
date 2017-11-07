package sparkop.compiler

import conf.Labels
import org.apache.jena.sparql.algebra.{Op, OpVisitorBase}
import org.apache.jena.sparql.algebra.op.{OpBGP, OpProject}
import sparkop.op.{SparkBGP, SparkOp, SparkProjection}

import scala.collection.JavaConversions._
import scala.collection.mutable

/**
  * @author xiangnan ren
  */
class SparkOpTransformer() extends OpVisitorBase {
  protected val stack = new mutable.Stack[SparkOp]

  def transform(op: Op): SparkOp = {
    OpWalker(this).walkBottomUp(op)
    stack.pop()
  }

  override def visit(opBGP: OpBGP): Unit = {
    val sparkBGP = SparkBGP(opBGP, opBGP.getPattern.getList.toList)
    sparkBGP.opName = Labels.SPARK_BGP_NAME
    stack.push(sparkBGP)
  }

  override def visit(opProject: OpProject): Unit = {
    val subOp: SparkOp = stack.pop()
    val sparkProject = SparkProjection(opProject, subOp)
    sparkProject.opName = Labels.SPARK_PROJECTION_NAME
    stack.push(sparkProject)
  }
}

object SparkOpTransformer {
  def apply(): SparkOpTransformer = new SparkOpTransformer()
}