package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Launcher.class);
        try {
            var rabbitTemplate = context.getBean(RabbitTemplate.class);
            Scanner scanner = new Scanner(System.in);
            String message;

            String instructMessage = "Input a message, we will sent it for " +
                    "you (q for quit)";
            System.out.println(instructMessage);
            while(scanner.hasNextLine())
            {
                message = scanner.nextLine();
                if (message.equals("q"))
                {
                    System.out.println("Bye");
                    break;
                }
                rabbitTemplate.convertAndSend("", "chat_messages", message);
                System.out.println("Message sent. " + instructMessage);
            }
        } finally {
            context.close();
        }
    }
}
