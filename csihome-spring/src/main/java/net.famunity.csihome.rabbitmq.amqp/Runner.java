package net.famunity.csihome.rabbitmq.amqp;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate, ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<10; i++) {
            if( i%2 == 0){
                System.out.println("Sending message..."+i);
                rabbitTemplate.convertAndSend(Application.queueName, (Object) ("Hello from RabbitMQ! another11 = "+i), new MessagePostProcessor(){
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
                        message.getMessageProperties().setPriority(11);
                        message.getMessageProperties().setContentEncoding("UTF-8");
                        return message;
                    }
                });
            } else {
                System.out.println("Sending message..."+i);
                rabbitTemplate.convertAndSend(Application.queueName, "Hello from RabbitMQ! another11 = " + i);
            }
        }
        context.close();
    }

}
