package sparkop.compiler
import org.apache.log4j.LogManager
import sparkop.op.{SparkBGP, SparkProjection}

/**
  * @author xiangnan ren
  */
class SparkOpVisitorBase extends SparkOpVisitor {
  @transient
  lazy val log = LogManager.getLogger(SparkOpVisitorBase.getClass)

  override def visit(sparkProject: SparkProjection): Unit = {
    log.error("BGP is not supported.")
    throw new UnsupportedOperationException("BGP is not supported.")
  }

  override def visit(sparkBGP: SparkBGP): Unit = {
    log.error("PROJECT is not supported.")
    throw new UnsupportedOperationException("PROJECT is not supported.")
  }
}

object SparkOpVisitorBase {
  def apply: SparkOpVisitorBase = new SparkOpVisitorBase()
}

