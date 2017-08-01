package net.famunity.csihome.rabbitmq.amqp;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receiveMessage(Object message) {
        if(message instanceof String){
            System.out.println("Received <" + message.toString() + ">");
        }
    }

}
