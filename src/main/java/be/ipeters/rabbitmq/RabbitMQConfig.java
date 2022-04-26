package be.ipeters.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    //public static final Logger logger = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Bean
    Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    Queue helloPojoQueue() {
        return new Queue("helloPojo");
    }
    @Bean
	public Queue anotherQueue() {
		return new Queue("anotherQueue");
	}

    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
