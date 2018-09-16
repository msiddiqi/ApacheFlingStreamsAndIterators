import org.apache.flink.streaming.api.datastream.DataStreamUtils
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, _}
import scala.collection.JavaConverters.asScalaIteratorConverter

object AppMain extends App {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val intStream = env.fromElements(1, 2, 3, 4, 5, 6)
    val doubleIntStream = intStream.map(item => item * 2)

    env.execute("InstituteManagementService")

    val doubleIterator = DataStreamUtils.collect[Int](doubleIntStream.javaStream)

    val scalaIterator = doubleIterator.asScala.toList
    scalaIterator.foreach(item => println(s"item: $item"))

    println("Completed!")
}


