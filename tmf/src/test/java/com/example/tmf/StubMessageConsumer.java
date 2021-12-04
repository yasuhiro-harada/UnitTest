package com.example.tmf;

import java.util.Properties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.time.Duration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StubMessageConsumer{

    @Value("${spring.kafka.producer.bootstrap-servers}") String consumerBootstrapServers;
    @Value("${spring.kafka.consumer.group-id}") String consumerGroupId;
    @Value("${spring.kafka.consumer.auto-offset-reset}") String consumerAutoOffsetReset;
    @Value("${spring.kafka.producer.topic}") String consumerTopic;
    @Value("${spring.kafka.consumer.timeout}") String consumerTimeout;
    @Value("${spring.kafka.consumer.frequency}") String consumerFrequency;
	
	public void consume(List<MessageKey> messageKeys, List<ResData> resDatas) throws Exception
	{
        KafkaConsumer<byte[], byte[]> consumer = null;
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerBootstrapServers);
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, consumerAutoOffsetReset);
		
		consumer = new KafkaConsumer<>(properties, new ByteArrayDeserializer(), new ByteArrayDeserializer());

		List<ConsumerRecord<byte[], byte[]>> received = new ArrayList<>();

		consumer.subscribe(Arrays.asList(consumerTopic));
		Duration duration = Duration.ofMillis(Long.parseLong(consumerTimeout));
		ConsumerRecords<byte[], byte[]> records = consumer.poll(duration);

		records.forEach(received::add);
		received = KafkaUtil.sort(received);
		for(int i = 0; i < received.size(); i++){
			MessageKey messageKey = KafkaUtil.deserializeMessageKey(received.get(i).key());
			ResData resData = KafkaUtil.deserializeResData(received.get(i).value());
			messageKeys.add(messageKey);
			resDatas.add(resData);
		}
		received.clear();
		consumer.close();
	}
}