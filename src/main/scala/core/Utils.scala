package core

import conf.Labels
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @author xiangnan ren
  */
object Utils {

  /**
    * Initialize the spark session with default configuration.
    */

  /**
    * Create the DataFrame from a given file:
    *  1. create the RDD from file;
    *  2. crate DF from RDD.
    *
    */
  def initializeDF(path: String): DataFrame = {
    val spark = SparkSession.
      builder().
      appName("Spark RDF App").
      config("spark.driver.host", "localhost").
      config("spark.driver.memory", "2g").
      config("spark.sql.shuffle.partitions", "8").
      config("spark.sql.autoBroadcastJoinThreshold", "-1").
      master("local[*]").
      getOrCreate()

    ???
  }

  def displayRunningTime[T](task: => T): Unit = {
    val tStart = System.nanoTime()
    task
    println(s"Time costs: ${(System.nanoTime() - tStart)/1e6}")
  }

}
