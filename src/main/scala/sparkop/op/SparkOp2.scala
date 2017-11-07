package sparkop.op

import org.apache.spark.sql.DataFrame

/**
  * @author xiangnan ren
  */
abstract class SparkOp2[S, T <: SparkOp](val leftOp: S,
                                         val rightOp: T) extends SparkOpBase {
  def execute(opName: String,
              leftChild: DataFrame,
              rightChild: DataFrame): DataFrame
}
