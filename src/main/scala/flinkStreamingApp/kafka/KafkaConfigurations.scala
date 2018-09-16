package flinkStreamingApp.kafka

object KafkaConfigurations {

  val groupId = "test"
  val schemaRegistryUrl = "localhost:8081"
  val bootstrapServers = "localhost:9092"
  val zookeepers = "localhost:2181"
}


object FlinkConfigurations {

  val identityMapCapacity = 1000
}