package sparkop.op

import org.apache.jena.graph
import org.apache.spark.sql.DataFrame

/**
  * @author xiangnan ren
  */
trait BGPUtils {

  protected val f_joinKey: (Array[String],Array[String]) => Seq[String] =
    (eftColName: Array[String],
                   rightColName: Array[String])=> {
    ???
  }


  protected def computeTriplePattern(triple: graph.Triple,
                           inputDF: DataFrame): DataFrame = {
    ???
  }
}
