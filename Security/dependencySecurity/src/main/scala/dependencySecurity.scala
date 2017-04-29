import org.apache.spark._
import org.apache.spark.SparkContext._
import java.net._
import java.io._
import scala.io._

object dependencySecurity {
	def main(args: Array[String]) {
		println("dependencySecurity")
		val input = args(0)
		//val output = args(1)
		val conf = new SparkConf().setAppName("dependencySecurityApp")
		val sc = new SparkContext(conf)
		val text =  sc.textFile(input)
		val words = text.flatMap(line => line.split(":"))
		val wc = words.map(mm).reduceByKey{case (x, y) => x + y}
		//save to .txt file locally
		/*wc.saveAsTextFile(output)*/
		println(wc.collect().mkString(", "))
	}
def mm(in: String): (String, Int) ={
	//replacing the desease using based on the name, here we want to, not rightfully, replace Amy's name with Jonathan
	if (in == "Amy"){
		println("************ Amy found")
		return ("Jonathan",1)
	}
	else
		(in, 1)
}
}
