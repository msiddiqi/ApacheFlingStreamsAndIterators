/*package flinkStreamingApp.kafka

import com.sksamuel.avro4s.RecordFormat
import org.apache.avro.generic.GenericRecord

object AvroHelper {

  def specific[T](genericRecord: GenericRecord)(implicit format: RecordFormat[T]) : T = {
    val specificRecord = format.from(genericRecord)
    specificRecord
  }

}
*/