package sparkop.op

import org.apache.spark.sql.DataFrame

/**
  * @author xiangnan ren
  */
abstract class SparkOp1[T <: SparkOp](val subOp: T) extends
  SparkOpBase {
  def execute(opName: String,
              child:  DataFrame): DataFrame
}
