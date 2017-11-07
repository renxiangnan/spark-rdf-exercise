package sparkop.op

import org.apache.spark.sql.DataFrame

/**
  * @author xiangnan ren
  */
abstract class SparkOp0 extends SparkOpBase {
  def execute(opName: String,
              inputDF: DataFrame): DataFrame
}
