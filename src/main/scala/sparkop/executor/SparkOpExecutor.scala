package sparkop.executor

import org.apache.spark.sql.DataFrame
import sparkop.compiler.{SparkOpVisitorBase, SparkOpWalker}
import sparkop.op.{SparkBGP, SparkOp, SparkProjection}

import scala.collection.mutable

/**
  * @author xiangnan ren
  */
class SparkOpExecutor (inputDF: DataFrame) extends
  SparkOpVisitorBase {
  protected val stack = new mutable.Stack[DataFrame]
  def execute(op: SparkOp): DataFrame = {
    SparkOpWalker(this).walkBottomUp(op)
    stack.pop()
  }

  override def visit(sparkBGP: SparkBGP): Unit = {
    stack.push(sparkBGP.
      execute(sparkBGP.opName, inputDF))
  }

  override def visit(sparkProjection: SparkProjection): Unit = {
    stack.push(sparkProjection.
      execute(sparkProjection.opName, stack.pop()))
  }
}

object SparkOpExecutor {
  def apply(inputDF: DataFrame): SparkOpExecutor = new SparkOpExecutor(inputDF)
}
