import java.net._
import java.io._
import scala.io._

object ScalaServer extends App
{
	val server = new ServerSocket(9999)
	println("Server has started...")
	while(true){
		try{
			val client = server.accept
			val rec = new BufferedReader(new InputStreamReader(client.getInputStream)).readLine
			val send = new PrintStream(client.getOutputStream)
			println("Server received ->" + rec)
			send.println("Msg ACK")
			send.flush
			if (rec.equals("Discon req")){
				send.println("Discon ACK")
				send.flush
				client.close;
			}
			
		}
		catch{
			case e: Exception =>
				println("EXCEPTION OCCURED:")
				println(e.getStackTrace);
		}
	}
	server.close;
	println("Server is closing...")
}
