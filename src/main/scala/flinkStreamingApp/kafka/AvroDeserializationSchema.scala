/*package flinkStreamingApp.kafka

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient
import org.apache.avro.generic.GenericRecord
import io.confluent.kafka.serializers.KafkaAvroDecoder
import org.apache.flink.api.common.serialization.DeserializationSchema
import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.api.java.typeutils.TypeExtractor

class AvroDeserializationSchema extends DeserializationSchema[GenericRecord] {

    val identityMapCapacity: Int = FlinkConfigurations.identityMapCapacity
    val schemaRegistryUri = KafkaConfigurations.schemaRegistryUrl

    private lazy val schemaRegistryClient =
        new CachedSchemaRegistryClient(schemaRegistryUri, identityMapCapacity)

    private lazy val kafkaAvroDecoder =
        new KafkaAvroDecoder(schemaRegistryClient)

    override def deserialize(message: Array[Byte]): GenericRecord = {
        kafkaAvroDecoder.fromBytes(message).asInstanceOf[GenericRecord]
    }

    override def isEndOfStream(nextElement: GenericRecord): Boolean = false

    override def getProducedType(): TypeInformation[GenericRecord] =
        TypeExtractor.getForClass(classOf[GenericRecord])

}
*/