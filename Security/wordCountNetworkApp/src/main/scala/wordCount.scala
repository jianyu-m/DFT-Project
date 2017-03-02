import org.apache.spark._
import org.apache.spark.SparkContext._
import java.net._
import java.io._
import scala.io._

object WordCount {
	def main(args: Array[String]) {
		val input = args(0)
		val output = args(1)
		val conf = new SparkConf().setAppName("wordCountApp")
		val sc = new SparkContext(conf)
		val text =  sc.textFile(input)
		val words = text.flatMap(line => line.split(" "))
		val wc = words.map(mm).reduceByKey{case (x, y) => x + y}
		//save to .txt file locally
		/*wc.saveAsTextFile(output)*/
		println(wc.collect().mkString(", "))
	}
def mm(in: String): (String, Int) ={
	//client to send individual words
	try{
		val socket = new Socket(InetAddress.getByName("localhost"), 9999)
		var rec = new BufferedSource(socket.getInputStream).getLines	
		val out = new PrintStream(socket.getOutputStream)
		out.println(in)
	}
	catch{
		case e: Exception => println(e.getStackTrace)
	}
	(in, 1)
}
}
