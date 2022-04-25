package be.ipeters.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ListenerService {

    //public static final Logger logger = LoggerFactory.getLogger(ListenerService.class);

    @RabbitListener(queues = "hello")
    public void getString(String message) {
        log.info("From Queue : {}", message);
    }

    @RabbitListener(queues = "helloPojo")
    public void getPojo(Notification message) {
        log.info("From Queue : {}", message);
    }
}
