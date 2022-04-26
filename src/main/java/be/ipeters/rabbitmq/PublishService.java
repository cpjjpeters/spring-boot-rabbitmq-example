package be.ipeters.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Slf4j
@Service
public class PublishService {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public PublishService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Scheduled(fixedDelay = 2000)
    public void anotherMessage() {
        String messageString = "Another Rabbit @ " + LocalTime.now().format(DateTimeFormatter.ISO_TIME);
        log.debug(messageString);
        rabbitTemplate.convertAndSend("anotherQueue",new Notification("Another Rabbit", LocalTime.now().format(DateTimeFormatter.ISO_TIME)));
    }


    @Scheduled(fixedDelay = 6000)
    public void pushMessage() {
        String messageString = "Hello Rabbit @ " + LocalTime.now().format(DateTimeFormatter.ISO_TIME);
        rabbitTemplate.convertAndSend("hello", messageString);
    }

    @Scheduled(fixedDelay = 5000)
    public void publishNotification() {
        rabbitTemplate.convertAndSend("helloPojo", new Notification("Hello Rabbit", LocalTime.now().format(DateTimeFormatter.ISO_TIME)));
    }
}