package be.ipeters.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RabbitmqApplication {

//	@Bean
//	public Queue helloQueue() {
//		return new Queue("hello");
//	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

}
