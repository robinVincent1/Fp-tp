// Databricks notebook source
import org.apache.spark.sql.SparkSession


// COMMAND ----------

import com.mongodb.spark._

val mongoUri = "mongodb+srv://mikadobetterave0s:qOIwZCI7joB3CvRo@fp.ejosi.mongodb.net/NEOJ.seed"

val mongoDF = spark.read
  .format("mongodb")
  .option("uri", mongoUri)
  .load()

val filteredDF = mongoDF
  .filter("ID LIKE 'CVE-2023%' OR ID LIKE 'CVE-2024%'")
  .select("ID", "Description", "ImpactScore")

filteredDF.show()

// COMMAND ----------

val neo4jOptions = Map(
  "url" -> "bolt+s://65b37d8f.databases.neo4j.io:7687",
  "authentication.type" -> "basic",
  "authentication.basic.username" -> "neo4j",
  "authentication.basic.password" -> "test"
)


filteredDF.write
  .format("org.neo4j.spark.DataSource")
  .mode("overwrite")
  .options(neo4jOptions)
  .option("node.keys", "ID") 
  .option("labels", ":CVE")
  .save()


val descriptionAndImpactDF = filteredDF.select("ID", "Description", "ImpactScore")
descriptionAndImpactDF.foreach { row =>
  val id = row.getAs[String]("ID")
  val description = row.getAs[String]("Description")
  val impactScore = row.getAs[Double]("ImpactScore")

  val query = s"""
    MATCH (c:CVE {ID: '$id'})
    MERGE (d:Description {text: '$description'})
    MERGE (i:ImpactScore {score: $impactScore})
    MERGE (c)-[:HAS]->(d)
    MERGE (c)-[:HAS]->(i)
  """

  val session = GraphDatabase.driver(neo4jOptions("url"), AuthTokens.basic(neo4jOptions("authentication.basic.username"), neo4jOptions("authentication.basic.password"))).session()
  session.run(query)
  session.close()
}

// COMMAND ----------

val neo4jQuery2024 = """
MATCH (c:CVE)-[:HAS]->(i:ImpactScore)
WHERE c.ID STARTS WITH 'CVE-2024'
RETURN c.ID AS CVE_ID, i.score AS ImpactScore
ORDER BY i.score DESC
LIMIT 5
"""

val top2024DF = spark.read
  .format("org.neo4j.spark.DataSource")
  .options(neo4jOptions)
  .option("query", neo4jQuery2024)
  .load()

top2024DF.show()

// COMMAND ----------

val neo4jQuery2023 = """
MATCH (c:CVE)-[:HAS]->(i:ImpactScore)
WHERE c.ID STARTS WITH 'CVE-2023' AND c.baseSeverity = 'MEDIUM'
RETURN c.ID AS CVE_ID, i.score AS ImpactScore
ORDER BY i.score DESC
LIMIT 5
"""

val top2023DF = spark.read
  .format("org.neo4j.spark.DataSource")
  .options(neo4jOptions)
  .option("query", neo4jQuery2023)
  .load()

top2023DF.show()

// COMMAND ----------

val neo4jQuerySeverity2024 = """
MATCH (c:CVE)-[:HAS]->(i:ImpactScore)
WHERE c.ID STARTS WITH 'CVE-2024' AND c.baseSeverity = 'MEDIUM'
RETURN c.ID AS CVE_ID, i.score AS ImpactScore
ORDER BY i.score DESC
LIMIT 5
"""

// COMMAND ----------

val neo4jQuerySeverity2023 = """
MATCH (c:CVE)-[:HAS]->(i:ImpactScore)
WHERE c.ID STARTS WITH 'CVE-2023' AND c.baseSeverity = 'MEDIUM'
RETURN c.ID AS CVE_ID, i.score AS ImpactScore
ORDER BY i.score DESC
LIMIT 5
"""
