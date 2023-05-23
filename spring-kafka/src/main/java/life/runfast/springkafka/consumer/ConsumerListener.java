package life.runfast.springkafka.consumer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

/**
 * @author noreply
 * @description
 * @datetime 2023/5/23 16:58
 */
@Component
public class ConsumerListener {

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("test")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @KafkaListener(id = "myId", topics = "test")
    public void listener(String in) {
        System.out.println(in);
    }
}
