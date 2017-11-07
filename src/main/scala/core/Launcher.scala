package core

import org.apache.jena.query.QueryFactory
import org.apache.jena.sparql.algebra.Algebra
import sparkop.compiler.SparkOpTransformer
import sparkop.executor.SparkOpExecutor

/**
  * @author xiangnan ren
  */
object Launcher extends App {
  /**
    * Currently the acceptable query type is limited as Select type.
    */
  val queryStr =
    "select ?s ?o1 " +
    " { " +
    " ?s <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?o ; " +
    "    <http://purl.oclc.org/NET/ssnx/ssn/isProducedBy> ?o1 ." +
    "} "
  val query = QueryFactory.create(queryStr)
  val opRoot = Algebra.compile(query)
  val transformedAlgebra = SparkOpTransformer().transform(opRoot)

  val filePath = ""
  val df = Utils.initializeDF(filePath)
  val res = SparkOpExecutor(df).execute(transformedAlgebra)

}
